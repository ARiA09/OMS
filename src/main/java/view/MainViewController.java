package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import jdbc.DatabaseConnection;
import model.Clazz;
import model.Course;

public class MainViewController implements Initializable {
    private DatabaseConnection db;
    private Connection conn;

    @FXML
    private Button closeButton;
    @FXML
    private TableView<Course> courses;
    @FXML
    private TableColumn<Course, String> courseName;
    @FXML
    private TableColumn<Course, String> coid;
    @FXML
    private TableColumn<Course, DateCell> co_start;
    @FXML
    private TableColumn<Course, DateCell> co_end;
    @FXML
    private TableColumn<Course, Clazz> co_room;

    @FXML
    private TableView<Clazz> classes;
    @FXML
    private TableColumn<Clazz, String> claID;
    @FXML
    private TableColumn<Clazz, String> cla_Name;
    @FXML
    private TableColumn<Clazz, String> cla_Room;


    public void initialize(URL location, ResourceBundle resources) {
        db = new DatabaseConnection();

        try {
            conn = db.getMySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        coid.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        coid.setCellFactory(TextFieldTableCell.forTableColumn());
        coid.setOnEditCommit(event -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            String co_update = event.getNewValue();
            System.out.println(co_id);
            System.out.println("Test");
            UpdateCourse(co_id, String.valueOf(co_update), "Course ID Update");
            allCourses().clear();
            courses.getItems().setAll(allCourses());
            courses.refresh();
        });

        courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        courseName.setCellFactory(TextFieldTableCell.forTableColumn());

        courseName.setOnEditCommit(event -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            String name_update = event.getNewValue();
            UpdateCourse(co_id, String.valueOf(name_update), "Course Name Update");
            allCourses().clear();
            courses.getItems().setAll(allCourses());
            courses.refresh();
        });

        co_start.setCellValueFactory(new PropertyValueFactory<>("CourseStart"));
        co_end.setCellValueFactory(new PropertyValueFactory<>("CourseEnd"));
        co_room.setCellValueFactory(new PropertyValueFactory<>("ClassName"));
        co_room.setCellFactory(ComboBoxTableCell.forTableColumn(allClasses()));

        co_room.setOnEditCommit(event -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            int cla_id = event.getNewValue().getCla_id();
            UpdateCourse(co_id, String.valueOf(cla_id), "Class Update");
            allCourses().clear();
            courses.getItems().setAll(allCourses());
            courses.refresh();
        });
        courses.getItems().setAll(allCourses());


        claID.setCellValueFactory(new PropertyValueFactory<>("claId"));
        cla_Name.setCellValueFactory(new PropertyValueFactory<>("cla_Name"));
        cla_Room.setCellValueFactory(new PropertyValueFactory<>("cla_Room"));

        classes.getItems().setAll(allClasses());


        closeButton.setOnAction(actionEvent -> {
            db.close();
            Platform.exit();
        });
    }

    private ObservableList<Course> allCourses() {
        ObservableList<Course> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT\n" +
                    "courses.co_name,\n" +
                    "classes.*,\n" +
                    "courses.co_id,\n" +
                    "courses.cla_id,\n" +
                    "courses.coid,\n" +
                    "courses.co_start_time,\n" +
                    "courses.co_end_time\n" +
                    "FROM\n" +
                    "classes\n" +
                    "RIGHT JOIN courses ON courses.cla_id = classes.cla_id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Course co = new Course();
                Clazz cl = new Clazz();
                co.setCourse_id(rs.getInt("co_id"));
                co.setCourseId(rs.getString("coid"));
                co.setCourseName(rs.getString("co_name"));
                co.setCourseStart(rs.getDate("co_start_time"));
                co.setCourseEnd(rs.getDate("co_end_time"));
                co.setClassName(rs.getString("cla_name"));
                cl.setCla_id(rs.getInt("cla_id"));
                cl.setClaId(rs.getString("claid"));
                cl.setCla_Name(rs.getString("cla_name"));
                cl.setCla_Room(rs.getString("cla_room"));
                co.setClazz(cl);
                data.add(co);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    private ObservableList<Clazz> allClasses() {
        ObservableList<Clazz> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = "Select * From Classes";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Clazz cla = new Clazz();
                cla.setCla_id(rs.getInt("cla_id"));
                cla.setClaId(rs.getString("claid"));
                cla.setCla_Name(rs.getString("cla_name"));
                cla.setCla_Room(rs.getString("cla_room"));
                data.add(cla);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void UpdateCourse(int course, String updateField, String typeUpdate) {
        try {
            Statement statement = conn.createStatement();
            String sql;
            switch (typeUpdate) {
                case "Class Update":
                    sql = String.format("UPDATE courses SET cla_id = %s Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
                case "Course Name Update":
                    sql = String.format("UPDATE courses SET co_name = %s Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
                case "Course ID Update":
                    sql = String.format("UPDATE courses SET coid = %s Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

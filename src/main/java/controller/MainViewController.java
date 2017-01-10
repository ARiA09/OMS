package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import main.Main;
import model.Clazz;
import model.Course;
import model.Student;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static main.Main.conn;

public class MainViewController implements Initializable, ControlledScreen {
    ScreensController myController;

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

    @FXML
    private Button newCourse;
    @FXML
    private Button refreshView;

    public void initialize(URL location, ResourceBundle resources) {
        // Control Course Screen
        // Update data
        // Create data
        coid.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        coid.setCellFactory(TextFieldTableCell.forTableColumn());
        coid.setOnEditCommit(event -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            String co_update = event.getNewValue();
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
        });
        courses.getItems().setAll(allCourses());

        // Control Class Screen
        // Update data
        // Create data
        claID.setCellValueFactory(new PropertyValueFactory<>("claId"));
        claID.setCellFactory(TextFieldTableCell.forTableColumn());
        claID.setOnEditCommit(event -> {
            int cla_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCla_id();
            String claId = event.getNewValue();
            UpdateClass(cla_id, claId, "Class ID Update");
            allClasses().clear();
            classes.getItems().setAll(allClasses());
        });
        cla_Name.setCellValueFactory(new PropertyValueFactory<>("cla_Name"));
        cla_Name.setCellFactory(TextFieldTableCell.forTableColumn());
        cla_Name.setOnEditCommit(event -> {
            int cla_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCla_id();
            String cla_name = event.getNewValue();
            UpdateClass(cla_id, cla_name, "Class Name Update");
            allClasses().clear();
            classes.getItems().setAll(allClasses());
        });
        cla_Room.setCellValueFactory(new PropertyValueFactory<>("cla_Room"));
        cla_Room.setCellFactory(TextFieldTableCell.forTableColumn());
        cla_Room.setOnEditCommit(event -> {
            int cla_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCla_id();
            String cla_room = event.getNewValue();
            UpdateClass(cla_id, cla_room, "Class Room Update");
            allClasses().clear();
            classes.getItems().setAll(allClasses());
        });

        classes.getItems().setAll(allClasses());


        refreshView.setOnAction(actionEvent -> {
            allCourses().clear();
            courses.getItems().setAll(allCourses());
        });
        newCourse.setOnAction(actionEvent -> myController.setScreen(Main.addCourseID));
        closeButton.setOnAction(actionEvent -> Platform.exit());

        // Control Student Screen
        // Update data
        // Create data
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

    public static ObservableList<Clazz> allClasses() {
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

    //    public static ObservableList<Student> allStudents() {
//        ObservableList<Student> data = FXCollections.observableArrayList();
//        try {
//            Statement statement = conn.createStatement();
//            String sql = "SELECT * From student_mark";
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                Student stu = new Student();
//                stu.setStu_id(rs.getInt("stu_id"));
//                stu.setStuid(rs.getString("stuid"));
//                stu.setStu_name(rs.getString("stu_name"));
//                stu.setStu_mark(rs.getDouble("stu_mark"));
//                data.add(stu);
//            }
//            for (Student a:data) {
//                Course aCourse = new Course();
//                while (rs.next()) {
//                    if(a.getStu_id() == rs.getInt("stu_id")){
//                       aCourse.setCourseName(rs.getString("co_name"));
//                       aCourse.s
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
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
                    sql = String.format("UPDATE courses SET co_name = '%s' Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
                case "Course ID Update":
                    sql = String.format("UPDATE courses SET coid = '%s' Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void UpdateClass(int clazz, String updateField, String typeUpdate) {
        try {
            Statement statement = conn.createStatement();
            String sql;
            switch (typeUpdate) {
                case "Class ID Update":
                    sql = String.format("UPDATE Classes SET claid = %s Where cla_id = %d", updateField, clazz);
                    statement.executeUpdate(sql);
                    break;
                case "Class Name Update":
                    sql = String.format("UPDATE Classes SET cla_name = '%s' Where cla_id = %d", updateField, clazz);
                    statement.executeUpdate(sql);
                    break;
                case "Class Room Update":
                    sql = String.format("UPDATE Classes SET cla_room = '%s' Where cla_id = %d", updateField, clazz);
                    statement.executeUpdate(sql);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}

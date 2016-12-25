package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbc.DatabaseConnection;
import model.Clazz;
import model.Course;

public class MainViewController implements Initializable {
    private DatabaseConnection db;

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
    private TableView<Clazz> classes;
    @FXML
    private TableColumn<Clazz, String> claID;
    @FXML
    private TableColumn<Clazz, String> cla_Name;
    @FXML
    private TableColumn<Clazz, String> cla_Room;


    public void initialize(URL location, ResourceBundle resources) {
        db = new DatabaseConnection();
        coid.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseId"));
        courseName.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseName"));
        co_start.setCellValueFactory(new PropertyValueFactory<Course, DateCell>("CourseStart"));
        co_end.setCellValueFactory(new PropertyValueFactory<Course, DateCell>("CourseEnd"));

        courses.getItems().setAll(allCourses());

        claID.setCellValueFactory(new PropertyValueFactory<Clazz, String>("claId"));
        cla_Name.setCellValueFactory(new PropertyValueFactory<Clazz, String>("cla_Name"));
        cla_Room.setCellValueFactory(new PropertyValueFactory<Clazz, String>("cla_Room"));

        classes.getItems().setAll(allClasses());

        db.close();
        closeButton.setOnAction(actionEvent -> Platform.exit());
    }

    private List<Course> allCourses() {
        List<Course> data = new ArrayList();
        try {
            Connection con = db.getMySQLConnection();
            Statement statement = con.createStatement();
            String sql = "Select * From Courses";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Course co = new Course();
                co.setCourse_id(rs.getInt("co_id"));
                co.setCourseId(rs.getString("coid"));
                co.setCourseName(rs.getString("co_name"));
                co.setCourseStart(rs.getDate("co_start_time"));
                co.setCourseEnd(rs.getDate("co_end_time"));
                data.add(co);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private List<Clazz> allClasses() {
        List<Clazz> data = new ArrayList();
        try {
            Connection con = db.getMySQLConnection();
            Statement statement = con.createStatement();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}

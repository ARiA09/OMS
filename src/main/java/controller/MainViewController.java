package controller;

import database.DataList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import main.Main;
import model.Clazz;
import model.Course;
import model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable, ControlledScreen {
    private ScreensController myController;

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
    private TableView<Student> students;
    @FXML
    private TableColumn<Student, String> stuID;
    @FXML
    private TableColumn<Student, String> stuName;
    @FXML
    private TableColumn<Student, Number> stuMarkTotal;
    @FXML
    private Label stu_Name;

    @FXML
    private Button newCourse;
    @FXML
    private Button refreshView;
    @FXML
    private Button newClass;
    @FXML
    private Button refreshClass;

    public void initialize(URL location, ResourceBundle resources) {
        DataList data = new DataList();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Control Course Screen
        // Update data
        // Create data
        coid.setSortType(TableColumn.SortType.ASCENDING);
        coid.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        coid.setCellFactory(TextFieldTableCell.forTableColumn());
        coid.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            String co_update = event.getNewValue();
            data.UpdateCourse(co_id, String.valueOf(co_update), "Course ID Update");
            courses.getItems().setAll(data.allCourses());
            courses.getSortOrder().add(coid);
        });

        courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        courseName.setCellFactory(TextFieldTableCell.forTableColumn());
        courseName.setOnEditCommit((TableColumn.CellEditEvent<Course, String> event) -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            String name_update = event.getNewValue();
            data.UpdateCourse(co_id, String.valueOf(name_update), "Course Name Update");
            courses.getItems().setAll(data.allCourses());
            courses.getSortOrder().add(coid);
        });

        co_start.setCellValueFactory(new PropertyValueFactory<>("CourseStart"));
        co_end.setCellValueFactory(new PropertyValueFactory<>("CourseEnd"));
        co_room.setCellValueFactory(new PropertyValueFactory<>("ClassName"));
        co_room.setCellFactory(ComboBoxTableCell.forTableColumn(data.allClasses()));
        co_room.setOnEditCommit(event -> {
            int co_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCourse_id();
            int cla_id = event.getNewValue().getCla_id();
            data.UpdateCourse(co_id, String.valueOf(cla_id), "Class Update");
            courses.getItems().setAll(data.allCourses());
            courses.getSortOrder().add(coid);
        });

        courses.getItems().setAll(data.allCourses());
        courses.getSortOrder().add(coid);

        refreshView.setOnAction(actionEvent -> {
            courses.getItems().setAll(data.allCourses());
            courses.getSortOrder().add(coid);
        });
        newCourse.setOnAction(actionEvent -> myController.setScreen(Main.addCourseID));
        closeButton.setOnAction(actionEvent -> Platform.exit());
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Control Class Screen
        // Update data
        // Create data
        claID.setSortType(TableColumn.SortType.ASCENDING);
        claID.setCellValueFactory(new PropertyValueFactory<>("claId"));
        claID.setCellFactory(TextFieldTableCell.forTableColumn());
        claID.setOnEditCommit(event -> {
            int cla_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCla_id();
            String claId = event.getNewValue();
            data.UpdateClass(cla_id, claId, "Class ID Update");
            classes.getItems().setAll(data.allClasses());
            classes.getSortOrder().add(claID);
        });

        cla_Name.setCellValueFactory(new PropertyValueFactory<>("cla_Name"));
        cla_Name.setCellFactory(TextFieldTableCell.forTableColumn());
        cla_Name.setOnEditCommit(event -> {
            int cla_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCla_id();
            String cla_name = event.getNewValue();
            data.UpdateClass(cla_id, cla_name, "Class Name Update");
            classes.getItems().setAll(data.allClasses());
            classes.getSortOrder().add(claID);
        });

        cla_Room.setCellValueFactory(new PropertyValueFactory<>("cla_Room"));
        cla_Room.setCellFactory(TextFieldTableCell.forTableColumn());
        cla_Room.setOnEditCommit(event -> {
            int cla_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getCla_id();
            String cla_room = event.getNewValue();
            data.UpdateClass(cla_id, cla_room, "Class Room Update");
            classes.getItems().setAll(data.allClasses());
            classes.getSortOrder().add(claID);
        });

        classes.getItems().setAll(data.allClasses());

        refreshClass.setOnAction(actionEvent -> {
            classes.getItems().setAll(data.allClasses());
            classes.getSortOrder().add(claID);
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Control Student Screen
        // Update data
        // Create data
        stuID.setSortType(TableColumn.SortType.ASCENDING);
        stuID.setCellValueFactory(new PropertyValueFactory<>("stuid"));
        stuID.setCellFactory(TextFieldTableCell.forTableColumn());
        stuID.setOnEditCommit(event -> {
            int stu_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getStu_id();
            String stuId = event.getNewValue();
            data.UpdateStudent(stu_id, stuId, "Student ID Update");
            students.getItems().setAll(data.allStudents());
            students.getSortOrder().add(stuID);
        });

        stuName.setCellValueFactory(new PropertyValueFactory<>("stu_name"));
        stuName.setCellFactory(TextFieldTableCell.forTableColumn());
        stuName.setOnEditCommit(event -> {
            int stu_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getStu_id();
            String stuName = event.getNewValue();
            data.UpdateStudent(stu_id, stuName, "Student Name Update");
            students.getItems().setAll(data.allStudents());
            students.getSortOrder().add(stuID);
        });

        stuMarkTotal.setCellValueFactory(new PropertyValueFactory<>("stu_mark"));
//        stuMarkTotal.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
//        stuMarkTotal.setOnEditCommit(event -> {
//            int stu_id = event.getTableView().getItems().get(event.getTablePosition().getRow()).getStu_id();
//            Number mark = event.getNewValue();
//            data.UpdateStudent(stu_id, mark, "Student Mark Update");
//        });

        students.setRowFactory(event -> {
            TableRow<Student> tr = new TableRow<>();
            tr.setOnMouseClicked(clickEvent -> {
                if (!tr.isEmpty() && clickEvent.getButton() == MouseButton.PRIMARY) {
                    stu_Name.setText(tr.getItem().getStu_name());
                }
            });
            return tr;
        });

        students.getItems().setAll(data.allStudents());
        students.getSortOrder().add(stuID);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}

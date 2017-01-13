package controller;


import database.DataList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import main.Main;
import model.Course;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;

import static main.Main.conn;


public class EnrollController implements Initializable, ControlledScreen {
    private ScreensController myController;
    @FXML
    private Button enroll;
    @FXML
    private ComboBox<Course> enrollCourse;
    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DataList data = new DataList();
        enrollCourse.getItems().setAll(data.allCourses());
        int stu_id_enroll = MainViewController.enrollStu[0].getStu_id();
        enroll.setOnAction(event -> {
            int co_id;

            if (!enrollCourse.getSelectionModel().isEmpty()) {
                co_id = enrollCourse.getSelectionModel().getSelectedItem().getCourse_id();
                insertStudentToCourse(stu_id_enroll, co_id);
                myController.setScreen(Main.mainViewID);
                System.out.println(stu_id_enroll);
                System.out.println(co_id);
            }

        });
        closeButton.setOnAction(actionEvent -> Platform.exit());
    }

    private void insertStudentToCourse(int stu_id, int co_id) {
        PreparedStatement preparedStatement;
        String sql;
        if (co_id > 0) {
            sql = "INSERT INTO stu_co(stu_id, co_id) VALUES (?,?)";

            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, stu_id);
                preparedStatement.setInt(2, co_id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                if (e instanceof SQLIntegrityConstraintViolationException) {
                    System.out.println("");
                    e.printStackTrace();
                } else {
                    System.out.println("SQL ERROR!!!");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }


}

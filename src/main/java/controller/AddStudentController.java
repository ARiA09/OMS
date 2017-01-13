package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;

import static main.Main.conn;

public class AddStudentController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @FXML
    private Button closeButton;
    @FXML
    private Button cnBtnStudent;
    @FXML
    private Button submitBtnStudent;

    @FXML
    private Label errMsg;
    @FXML
    private TextField stu_nameTxt;
    @FXML
    private TextField stu_idTxt;
    @FXML
    private TextField stu_passwordTxt;

    private boolean updateFailed;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errMsg.setVisible(false);
        closeButton.setOnAction(actionEvent -> Platform.exit());
        submitBtnStudent.setOnAction(actionEvent -> {
            updateFailed = false;

            insertStudent(stu_idTxt.getText(), stu_nameTxt.getText(), stu_passwordTxt.getText());
            if (updateFailed) {
                return;
            }
            stu_idTxt.clear();
            stu_nameTxt.clear();
            stu_passwordTxt.clear();
            myController.setScreen(Main.mainViewID);
        });

        cnBtnStudent.setOnAction(actionEvent -> {
            stu_idTxt.clear();
            stu_nameTxt.clear();
            stu_passwordTxt.clear();
            //ERRO CLASS
            myController.setScreen(Main.mainViewID);
            errMsg.setVisible(false);
            errMsg.setText("");
        });
    }

    private void insertStudent(String stuid, String stu_name, String stu_password) {
        PreparedStatement preparedStatement;
        String sql;
        if (stuid != null && stu_name != null && stu_password != null) {
            sql = "INSERT INTO Students(stuid, stu_name, stu_password, stu_username) VALUES (?,?,?,?)";
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, stuid);
                preparedStatement.setString(2, stu_name);
                preparedStatement.setString(3, stu_password);
                preparedStatement.setString(4, stu_name);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                if (e instanceof SQLIntegrityConstraintViolationException) {
                    //e.printStackTrace();
                    errMsg.setText("This Student ID already exist!!!");
                    System.out.println("This Student ID already exist!!!");
                    errMsg.setVisible(true);
                    updateFailed = true;
                } else {
                    System.out.println("SQL ERROR!!!");
                    //e.printStackTrace();
                }
            }
        } else {
            errMsg.setText("Please input all required form!!!");
        }
    }
}


package controller;

import database.DataList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import model.Student;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static main.Main.conn;


public class LoginController implements Initializable, ControlledScreen {
    public static Student loginStudent = new Student();
    ScreensController myController;
    @FXML
    private Button closeButton;
    @FXML
    private Button login;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errorMsg.setVisible(false);
        closeButton.setOnAction(actionEvent -> Platform.exit());

        login.setOnAction(ActionEvent -> {
            if (checkExist(userName.getText(), password.getText())) {
                myController.setScreen(Main.mainViewID);
            } else {
                errorMsg.setText("Wrong UserName/Password !!!");
                errorMsg.setVisible(true);
            }
        });
    }


    private boolean checkExist(String userName, String password) {
        DataList data = new DataList();
        boolean resultCheck = false;
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("Select * From Students Where stu_name = '%s' and stu_password = '%s'", userName, password);
            ResultSet rs = statement.executeQuery(sql);
            resultCheck = rs.first();
            if (rs.first()) {
                loginStudent.setStuid(rs.getString("stuid"));
                loginStudent.setStu_name(rs.getString("stu_name"));
                loginStudent.setStu_id(rs.getInt("stu_id"));
                loginStudent.setStu_role(rs.getInt("stu_role"));
                loginStudent.setStu_mark(rs.getDouble("stu_mark"));
                loginStudent.setCo_mark(data.allDetail(rs.getInt("stu_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultCheck;
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}

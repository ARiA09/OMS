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

public class AddClassController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @FXML
    private Button closeButton;
    @FXML
    private Button cnBtnClass;
    @FXML
    private Button submitBtnClass;

    @FXML
    private Label errMsg;
    @FXML
    private TextField class_nameTxt;
    @FXML
    private TextField class_idTxt;
    @FXML
    private TextField class_roomTxt;

    private boolean updateFailed;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errMsg.setVisible(false);
        closeButton.setOnAction(actionEvent -> Platform.exit());

        submitBtnClass.setOnAction(actionEvent -> {
            updateFailed = false;

            insertClass(class_idTxt.getText(), class_nameTxt.getText(), class_roomTxt.getText());
            if (updateFailed) {
                return;
            }
            class_idTxt.clear();
            class_nameTxt.clear();
            class_roomTxt.clear();
            myController.setScreen(Main.mainViewID);
        });

        cnBtnClass.setOnAction(actionEvent -> {
            class_idTxt.clear();
            class_nameTxt.clear();
            class_roomTxt.clear();
            myController.setScreen(Main.mainViewID);
            errMsg.setVisible(false);
        });
    }

    private void insertClass(String claid, String cla_name, String cla_room) {
        PreparedStatement preparedStatement;
        String sql;
        if (claid != null && cla_name != null) {
            if (cla_room != null) {
                sql = "INSERT INTO classes(claid, cla_name, cla_room) VALUES (?,?,?)";
            } else {
                sql = "INSERT INTO classes(claid, cla_name) VALUES (?,?)";
            }
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, claid);
                preparedStatement.setString(2, cla_name);
                if (cla_room != null) preparedStatement.setString(3, cla_room);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                if (e instanceof SQLIntegrityConstraintViolationException) {
                    //e.printStackTrace();
                    errMsg.setText("This Class ID already exist!!!");
                    System.out.println("This Class ID already exist!!!");
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


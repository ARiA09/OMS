package controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.Main;
import model.Clazz;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;

import static main.Main.conn;

public class AddController implements Initializable, ControlledScreen {
    ScreensController myController;
    ObservableList<Clazz> allClasses = MainViewController.allClasses();
    @FXML
    private Button closeButton;
    @FXML
    private Button cnBtn;
    @FXML
    private Button submitBtn;

    @FXML
    private TextField co_idTxt;
    @FXML
    private TextField co_nameTxt;
    @FXML
    private DatePicker co_date_startTxt;
    @FXML
    private DatePicker co_date_endTxt;
    @FXML
    private ComboBox<Clazz> co_roomTxt;

    @FXML
    private Label errMsg;

    private boolean updateFailed = false;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errMsg.setVisible(false);
        co_roomTxt.getItems().setAll(allClasses);
        closeButton.setOnAction(actionEvent -> Platform.exit());

        cnBtn.setOnAction(actionEvent -> {
            co_idTxt.clear();
            co_nameTxt.clear();
            co_date_startTxt.setValue(null);
            co_date_endTxt.setValue(null);
            co_roomTxt.setValue(null);
            myController.setScreen(Main.mainViewID);
            errMsg.setVisible(false);
        });

        submitBtn.setOnAction(actionEvent -> {

            if (co_idTxt.getText() == null || co_nameTxt.getText() == null || co_date_startTxt.getValue() == null || co_date_endTxt.getValue() == null) {
                errMsg.setText("Please input all required fields");
                errMsg.setVisible(true);
            } else {
                insertCourse(co_roomTxt.getValue(), co_idTxt.getText(), co_nameTxt.getText(), co_date_startTxt, co_date_endTxt);
                if (updateFailed) {
                    return;
                }
                co_idTxt.clear();
                co_nameTxt.clear();
                co_date_startTxt.setValue(null);
                co_date_endTxt.setValue(null);
                co_roomTxt.setValue(null);
                myController.setScreen(Main.mainViewID);
                errMsg.setVisible(false);
            }
        });
    }

    private void insertCourse(Clazz cla_id, String coid, String co_name, DatePicker co_start_time, DatePicker co_end_time) {
        PreparedStatement preparedStatement;
        String sql;
        if (cla_id != null) {
            sql = "INSERT INTO courses(coid, co_name, co_start_time, co_end_time, cla_id) VALUES (?,?,?,?,?)";
        } else {
            sql = "INSERT INTO courses(coid, co_name, co_start_time, co_end_time) VALUES (?,?,?,?)";
        }
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, coid);
            preparedStatement.setString(2, co_name);
            preparedStatement.setDate(3, java.sql.Date.valueOf(co_start_time.getValue()));
            preparedStatement.setDate(4, java.sql.Date.valueOf(co_end_time.getValue()));
            if (cla_id != null) {
                preparedStatement.setInt(5, cla_id.getCla_id());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                //e.printStackTrace();
                errMsg.setText("This Course ID already exist!!!");
                System.out.println("This Course ID already exist!!!");
                errMsg.setVisible(true);
                updateFailed = true;
            } else {
                //e.printStackTrace();
            }
        }
    }
}


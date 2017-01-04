package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable, ControlledScreen {
    ScreensController myController;

    @FXML
    private Button login;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setOnAction(ActionEvent -> {
            myController.setScreen(Main.screen2ID);
        });
    }


}

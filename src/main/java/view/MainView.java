package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("Student Management System");

            Pane root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


            Pane coursePanel = FXMLLoader.load(getClass().getResource("AddingCourse.fxml"));
            Scene courseScene = new Scene(coursePanel, 600, 400);
            courseScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


            primaryStage.setResizable(false);
            //primaryStage.setScene(scene);
            primaryStage.setScene(courseScene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

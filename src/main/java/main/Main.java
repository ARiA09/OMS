package main;

import controller.ScreensController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static String login = "Login";
    public static String loginS1 = "Login.fxml";
    public static String screen2ID = "MainView";
    public static String screen2File = "MainView.fxml";
    public static String screen3ID = "Add";
    public static String screen3File = "AddingCourse.fxml";


    @Override
    public void start(Stage primaryStage) {
        ScreensController mainContainer = new ScreensController();

        mainContainer.loadScreen(Main.login, Main.loginS1);
        mainContainer.loadScreen(Main.screen2ID, Main.screen2File);
        mainContainer.loadScreen(Main.screen3ID, Main.screen3File);


        mainContainer.setScreen(Main.login);


        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

//        try {
//            primaryStage.initStyle(StageStyle.UNDECORATED);
//            primaryStage.setTitle("Student Management System");
//
//            Pane root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
//            Scene scene = new Scene(root, 800, 600);
//            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//
//
//            Pane coursePanel = FXMLLoader.load(getClass().getResource("AddingCourse.fxml"));
//            Scene courseScene = new Scene(coursePanel, 600, 400);
//            courseScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//
//            Pane loginPanel = FXMLLoader.load(getClass().getResource("Login.fxml"));
//            Scene loginScene = new Scene(loginPanel, 600, 400);
//            loginScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
//
//            primaryStage.setResizable(false);
//            //primaryStage.setScene(scene);
//            primaryStage.setScene(loginScene);
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

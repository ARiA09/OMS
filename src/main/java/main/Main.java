package main;

import controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import database.DatabaseConnection;

import java.sql.Connection;

public class Main extends Application {

    private static String loginID = "Login";
    private static String loginFile = "/view/Login.fxml";
    public static String mainViewID = "MainView";
    private static String mainViewFile = "/view/MainView.fxml";
    public static String addCourseID = "AddCourse";
    private static String addCourseFile = "/view/AddingCourse.fxml";
    private static DatabaseConnection db;
    public static Connection conn;

    @Override
    public void start(Stage primaryStage) {
        final PosWindow dragWin = new PosWindow();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Student Management System");

        ScreensController mainContainer = new ScreensController();

        mainContainer.loadScreen(Main.loginID, Main.loginFile);
        mainContainer.loadScreen(Main.mainViewID, Main.mainViewFile);
        mainContainer.loadScreen(Main.addCourseID, Main.addCourseFile);

        mainContainer.setScreen(Main.loginID);


        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);

        root.setOnMousePressed(mouseEvent -> {
            dragWin.x = primaryStage.getX() - mouseEvent.getScreenX();
            dragWin.y = primaryStage.getY() - mouseEvent.getScreenY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getScreenX() + dragWin.x);
            primaryStage.setY(mouseEvent.getScreenY() + dragWin.y);
        });

        scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        db = new DatabaseConnection();

        try {
            conn = db.getMySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        launch(args);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            db.close();
            System.out.println("Good Bye");
        }));
    }

    private class PosWindow {
        double x, y;
    }
}
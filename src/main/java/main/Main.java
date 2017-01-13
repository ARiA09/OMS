package main;

import controller.ScreensController;
import database.DatabaseConnection;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;

public class Main extends Application {

    public static String mainViewID = "MainView";
    public static String addCourseID = "AddCourse";
    public static String testID = "Test";
    public static String testFile = "/view/TestView.fxml";
    public static String addClassID = "AddClass";
    public static String addStudentID = "AddStudent";
    public static Connection conn;
    public static ScreensController mainContainer;
    public static String enrollID = "Enroll";
    public static String enrollFile = "/view/Enroll.fxml";
    private static String loginID = "Login";
    private static String loginFile = "/view/Login.fxml";
    private static String mainViewFile = "/view/MainView.fxml";
    private static String addCourseFile = "/view/AddingCourse.fxml";
    private static String addClassFile = "/view/AddingClass.fxml";
    private static String addStudentFile = "/view/AddingStudent.fxml";
    private static DatabaseConnection db;

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

    @Override
    public void start(Stage primaryStage) {
        final PosWindow dragWin = new PosWindow();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Student Management System");

        mainContainer = new ScreensController();

        mainContainer.loadScreen(Main.loginID, Main.loginFile);
        mainContainer.loadScreen(Main.mainViewID, Main.mainViewFile);
        mainContainer.loadScreen(Main.addCourseID, Main.addCourseFile);
        mainContainer.loadScreen(Main.testID, Main.testFile);
        mainContainer.loadScreen(Main.addClassID, Main.addClassFile);
        mainContainer.loadScreen(Main.addStudentID, Main.addStudentFile);
        mainContainer.loadScreen(Main.enrollID, Main.enrollFile);

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

    private class PosWindow {
        double x, y;
    }
}
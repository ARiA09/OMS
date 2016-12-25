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
			Pane root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setTitle("Student Management System");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

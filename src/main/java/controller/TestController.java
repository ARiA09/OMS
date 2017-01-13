package controller;


import database.DataList;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Answer;
import model.Question;
import model.Stu_co;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable, ControlledScreen {
    private ScreensController myController;

    @FXML
    private Button closeButton;
    @FXML
    private Button preButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button submitButton;
    @FXML
    private Button startTest;
    @FXML
    private Button goHome;
    @FXML
    private Label testName;
    @FXML
    private Label questionDetail;
    @FXML
    private TableView<Answer> answerData;
    @FXML
    private TableColumn<Answer, String> answerDetail;
    private DataList data = new DataList();
    private ObservableList<Question> allQ;
    private int indexQ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testName.setText(MainViewController.coName + " Test");
        questionDetail.setText("Please press 'Start' to begin the test");


        allQ = data.allQuestion(1);
        answerData.getItems().clear();
        startTest();

        int[] Total = new int[300];

        indexQ = 0;
        preButton.setVisible(false);
        submitButton.setVisible(false);
        nextButton.setVisible(false);
        startTest.setVisible(true);
        goHome.setVisible(false);
        answerDetail.setCellValueFactory(new PropertyValueFactory<>("detail"));

        preButton.setOnAction(actionEvent -> {
            if (!answerData.getSelectionModel().isEmpty())
                Total[indexQ] = answerData.getSelectionModel().getSelectedItem().getResult();

            indexQ--;

            nextButton.setVisible(true);

            if (indexQ == 0) preButton.setVisible(false);

            questionDetail.setText(allQ.get(indexQ).getDetail());
            answerData.getItems().clear();
            answerData.getItems().setAll(allQ.get(indexQ).getAnswers());
        });

        nextButton.setOnAction(actionEvent -> {
            if (!answerData.getSelectionModel().isEmpty())
                Total[indexQ] = answerData.getSelectionModel().getSelectedItem().getResult();

            indexQ++;

            preButton.setVisible(true);
            if (indexQ == allQ.size() - 1) {
                nextButton.setVisible(false);
                submitButton.setVisible(true);
            }

            questionDetail.setText(allQ.get(indexQ).getDetail());
            answerData.getItems().clear();
            answerData.getItems().setAll(allQ.get(indexQ).getAnswers());
        });

        submitButton.setOnAction(event -> {
            if (!answerData.getSelectionModel().isEmpty())
                Total[indexQ] = answerData.getSelectionModel().getSelectedItem().getResult();

            int allMark = 0;
            for (int all : Total) {
                allMark += all;
            }
            preButton.setVisible(false);
            submitButton.setVisible(false);
            nextButton.setVisible(false);
            answerData.getItems().clear();
            questionDetail.setText("Total point: " + allMark);
            System.out.println(allMark);
            goHome.setVisible(true);
            startTest.setVisible(true);
        });

        goHome.setOnAction(event -> {
            //mainContainer.unloadScreen(Main.testID);
            myController.setScreen(Main.mainViewID);
            answerData.getItems().clear();
        });
        closeButton.setOnAction(actionEvent -> Platform.exit());
    }

    private void startTest() {
        startTest.setOnAction(event -> {
            if (MainViewController.coTest > 0) {
                Stu_co aTest = LoginController.loginStudent.getCo_mark().get(MainViewController.coTest - 1);
                if (aTest.getMark_co() > 0) {
                    questionDetail.setText("You already take a test!!!\nThe score is: " + aTest.getMark_co());
                    goHome.setVisible(true);
                    startTest.setVisible(false);
                } else if (aTest.getMark_co() <= 0) {
                    goHome.setVisible(false);
                    int coid = MainViewController.coTest;
                    allQ = data.allQuestion(coid);
                    nextButton.setVisible(true);
                    questionDetail.setText(allQ.get(indexQ).getDetail());
                    startTest.setVisible(false);
                    answerData.getItems().clear();
                    answerData.getItems().setAll(allQ.get(indexQ).getAnswers());
                }
            }

        });
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
}

package model;


import javafx.collections.ObservableList;

import java.util.List;

public class Question {
    private int ques_id;
    private String quesid;
    private int co_id;
    private String detail;
    private ObservableList<Answer> Answers;

    public Question() {
    }

    public int getQues_id() {
        return ques_id;
    }

    public ObservableList<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(ObservableList<Answer> answers) {
        Answers = answers;
    }

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCo_id() {

        return co_id;
    }

    public void setCo_id(int co_id) {
        this.co_id = co_id;
    }

    public String getQuesid() {

        return quesid;
    }

    public void setQuesid(String quesid) {
        this.quesid = quesid;
    }
}

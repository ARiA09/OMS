package database;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

import static main.Main.conn;

public class DataList {

    public DataList() {
    }

    public ObservableList<Course> allCourses() {
        ObservableList<Course> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT\n" +
                    "courses.co_name,\n" +
                    "classes.*,\n" +
                    "courses.co_id,\n" +
                    "courses.cla_id,\n" +
                    "courses.coid,\n" +
                    "courses.co_start_time,\n" +
                    "courses.co_end_time\n" +
                    "FROM\n" +
                    "classes\n" +
                    "RIGHT JOIN courses ON courses.cla_id = classes.cla_id";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Course co = new Course();
                Clazz cl = new Clazz();
                co.setCourse_id(rs.getInt("co_id"));
                co.setCourseId(rs.getString("coid"));
                co.setCourseName(rs.getString("co_name"));
                co.setCourseStart(rs.getDate("co_start_time"));
                co.setCourseEnd(rs.getDate("co_end_time"));
                co.setClassName(rs.getString("cla_name"));
                cl.setCla_id(rs.getInt("cla_id"));
                cl.setClaId(rs.getString("claid"));
                cl.setCla_Name(rs.getString("cla_name"));
                cl.setCla_Room(rs.getString("cla_room"));
                co.setClazz(cl);
                data.add(co);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Course> specificCourses(int CourseID) {
        ObservableList<Course> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("SELECT * From Courses Where co_id = %d", CourseID);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Course aCourse = new Course();
                aCourse.setCourse_id(rs.getInt("co_id"));
                aCourse.setCourseId(rs.getString("coid"));
                aCourse.setCourseName(rs.getString("co_name"));
                aCourse.setCourseStart(rs.getDate("co_start_time"));
                aCourse.setCourseEnd(rs.getDate("co_end_time"));
                data.add(aCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Clazz> allClasses() {
        ObservableList<Clazz> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = "Select * From Classes";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Clazz cla = new Clazz();
                cla.setCla_id(rs.getInt("cla_id"));
                cla.setClaId(rs.getString("claid"));
                cla.setCla_Name(rs.getString("cla_name"));
                cla.setCla_Room(rs.getString("cla_room"));
                data.add(cla);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Stu_co> allDetail(int StudentID) {
        ObservableList<Stu_co> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("SELECT * From stu_co Where stu_id = %d", StudentID);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Stu_co stu_co = new Stu_co();
                stu_co.setStu_coid(rs.getInt("stu_co_id"));
                stu_co.setStuid(rs.getInt("stu_id"));
                stu_co.setCoid(rs.getInt("co_id"));
                stu_co.setMark_co(rs.getDouble("co_mark"));
                data.add(stu_co);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Student> allStudents() {
        ObservableList<Student> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();

            String sql = "SELECT * From students";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student stu = new Student();
                stu.setStu_id(rs.getInt("stu_id"));
                stu.setStuid(rs.getString("stuid"));
                stu.setStu_name(rs.getString("stu_name"));
                stu.setStu_mark(rs.getDouble("stu_mark"));
                data.add(stu);
            }

            for (Student aStu : data) {
                aStu.setCo_mark(allDetail(aStu.getStu_id()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    private ObservableList<Answer> allAnswers(int QuestionID) {
        ObservableList<Answer> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("SELECT * From Answers Where ques_id = %d ORDER BY RAND()", QuestionID);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Answer ans = new Answer();
                ans.setAns_id(rs.getInt("ans_id"));
                ans.setQues_id(rs.getInt("ques_id"));
                ans.setDetail(rs.getString("ans_detail"));
                ans.setResult(rs.getInt("ans_result"));
                data.add(ans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ObservableList<Question> allQuestion(int CourseID) {
        ObservableList<Question> data = FXCollections.observableArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = String.format("SELECT * From Questions Where co_id = %d", CourseID);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Question ques = new Question();
                ques.setQues_id(rs.getInt("ques_id"));
                ques.setQuesid(rs.getString("quesid"));
                ques.setDetail(rs.getString("ques_detail"));
                data.add(ques);
            }
            for (Question aQuestion : data) {
                aQuestion.setAnswers(allAnswers(aQuestion.getQues_id()));
            }
            Collections.shuffle(data);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void UpdateCourse(int course, String updateField, String typeUpdate) {
        try {
            Statement statement = conn.createStatement();
            String sql;
            switch (typeUpdate) {
                case "Class Update":
                    sql = String.format("UPDATE courses SET cla_id = %s Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
                case "Course Name Update":
                    sql = String.format("UPDATE courses SET co_name = '%s' Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
                case "Course ID Update":
                    sql = String.format("UPDATE courses SET coid = '%s' Where courses.co_id = %d", updateField, course);
                    statement.executeUpdate(sql);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void UpdateClass(int clazz, String updateField, String typeUpdate) {
        try {
            Statement statement = conn.createStatement();
            String sql;
            switch (typeUpdate) {
                case "Class ID Update":
                    sql = String.format("UPDATE Classes SET claid = %s Where cla_id = %d", updateField, clazz);
                    statement.executeUpdate(sql);
                    break;
                case "Class Name Update":
                    sql = String.format("UPDATE Classes SET cla_name = '%s' Where cla_id = %d", updateField, clazz);
                    statement.executeUpdate(sql);
                    break;
                case "Class Room Update":
                    sql = String.format("UPDATE Classes SET cla_room = '%s' Where cla_id = %d", updateField, clazz);
                    statement.executeUpdate(sql);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateStudent(int student, String updateField, String typeUpdate) {
        try {
            Statement statement = conn.createStatement();
            String sql;
            switch (typeUpdate) {
                case "Student ID Update":
                    sql = String.format("UPDATE Students SET stuid = %s Where stu_id = %d", updateField, student);
                    statement.executeUpdate(sql);
                    break;
                case "Student Name Update":
                    sql = String.format("UPDATE Students SET stu_name = '%s' Where stu_id = %d", updateField, student);
                    statement.executeUpdate(sql);
                    break;
                case "Student Mark Update":
                    sql = String.format("UPDATE Students SET stu_mark = %s Where stu_id = %d", updateField, student);
                    statement.executeUpdate(sql);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

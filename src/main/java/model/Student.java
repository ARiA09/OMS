package model;

import java.util.List;

public class Student {
    private int stu_id;
    private String stuid;
    private String stu_name;
    private Double stu_mark;
    private String stu_username;
    private String stu_password;
    private int stu_role;
    private List<Course> course;

    public Student() {
    }

    public int getStu_role() {
        return stu_role;
    }

    public void setStu_role(int stu_role) {
        this.stu_role = stu_role;
    }

    public String getStu_password() {

        return stu_password;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }

    public String getStu_username() {

        return stu_username;
    }

    public void setStu_username(String stu_username) {
        this.stu_username = stu_username;
    }

    public Double getStu_mark() {

        return stu_mark;
    }

    public void setStu_mark(Double stu_mark) {
        this.stu_mark = stu_mark;
    }

    public String getStu_name() {

        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStuid() {

        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}

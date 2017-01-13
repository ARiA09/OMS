package model;

import java.sql.Date;

public class Course {
    private int Course_id;
    private String CourseId;
    private String CourseName;
    private String ClassName;
    private Date CourseStart;
    private Date CourseEnd;
    private Clazz Clazz;

    public Course() {
    }

    public int getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(int course_id) {
        Course_id = course_id;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Date getCourseStart() {
        return CourseStart;
    }

    public void setCourseStart(Date courseStart) {
        CourseStart = courseStart;
    }

    public Date getCourseEnd() {
        return CourseEnd;
    }

    public void setCourseEnd(Date courseEnd) {
        CourseEnd = courseEnd;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public model.Clazz getClazz() {
        return Clazz;
    }

    public void setClazz(Clazz clazz) {
        Clazz = clazz;
    }

    @Override
    public String toString() {
        return CourseName;
    }
}

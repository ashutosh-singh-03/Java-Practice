package com.model;

public class Course {
    private final String courseId;
    private String courseName;
    private Department department;
    private Faculty faculty;
    private int semester;
    private int maximumSeats;

    public Course(
            String courseId, String courseName, Department department, Faculty faculty, int semester,
            int maximumSeats
    ) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.faculty = faculty;
        this.semester = semester;
        this.maximumSeats = maximumSeats;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMaximumSeats() {
        return maximumSeats;
    }

    public void setMaximumSeats(int maximumSeats) {
        this.maximumSeats = maximumSeats;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName=" + courseName +
                ", department=" + department.departmentName() +
                ", faculty=" + faculty.getName() +
                ", semester='" + semester + '\'' +
                ", maximumSeats=" + maximumSeats +
                '}';
    }
}

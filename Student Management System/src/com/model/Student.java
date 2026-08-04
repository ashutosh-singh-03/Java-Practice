package com.model;

import com.enums.Gender;
import com.enums.StudentStatus;

public class Student {
    private final String studentId;
    private String name;
    private int age;
    private final Gender gender;
    private String email;
    private String phone;
    private Department department;
    private int semester;
    private float cgpa;
    private StudentStatus status;

    public Student(String studentId, String name, int age, Gender gender, String email, String phone,
                   Department department, int semester, float cgpa, StudentStatus status) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSemester() {
        return semester;
    }

    public float getCgpa() {
        return cgpa;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department=" + department +
                ", semester='" + semester + '\'' +
                ", cgpa=" + cgpa +
                ", status='" + status + '\'' +
                '}';
    }
}

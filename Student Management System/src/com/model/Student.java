package com.model;

import com.enums.Gender;
import com.enums.StudentStatus;

import java.time.LocalDate;

public class Student {
    private final int studentId;
    private String name;
    private int age;
    private final Gender gender;
    private String email;
    private String phone;
    private String address;
    private Department department;
    private int semester;
    private LocalDate admissionDate;
    private float cgpa;
    private StudentStatus status;

    public Student(int studentId, String name, int age, Gender gender, String email, String phone, String address,
                   Department department, int semester, LocalDate admissionDate, float cgpa, StudentStatus status) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.semester = semester;
        this.admissionDate = admissionDate;
        this.cgpa = cgpa;
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public int getStudentId() {
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

    public String getAddress() {
        return address;
    }

    public int getSemester() {
        return semester;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
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
                ", address='" + address + '\'' +
                ", department=" + department +
                ", semester='" + semester + '\'' +
                ", admissionDate=" + admissionDate +
                ", cgpa=" + cgpa +
                ", status='" + status + '\'' +
                '}';
    }
}

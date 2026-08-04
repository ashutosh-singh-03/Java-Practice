package com.model;

import com.enums.Gender;
import com.enums.StudentStatus;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private final String studentId;
    private String name;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private String email;
    private String phone;
    private Department department;
    private int semester;
    private float cgpa;
    private StudentStatus status;

    public Student(String studentId, String name, LocalDate dateOfBirth, Gender gender, String email, String phone,
                   Department department, int semester, float cgpa, StudentStatus status) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public void graduate() {
        this.status = StudentStatus.GRADUATED;
    }

    public boolean isActive() {
        return status == StudentStatus.ACTIVE;
    }

    public boolean isGraduated() {
        return status == StudentStatus.GRADUATED;
    }

    public int getAge() {
        LocalDate current = LocalDate.now();

        Period age = Period.between(dateOfBirth, current);
        return age.getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + getAge() +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department=" + department.departmentName() +
                ", semester=" + semester +
                ", cgpa=" + cgpa +
                ", status=" + status +
                '}';
    }
}

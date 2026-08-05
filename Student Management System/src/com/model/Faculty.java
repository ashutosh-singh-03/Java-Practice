package com.model;

public class Faculty {
    private final String facultyId;
    private String name;
    private String designation;
    private String experience;
    private String email;
    private String phone;
    private Department department;

    public Faculty(
            String facultyId, String name, String designation, String experience, String email, String phone, Department department
    ) {
        this.facultyId = facultyId;
        this.name = name;
        this.designation = designation;
        this.experience = experience;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId='" + facultyId + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", experience='" + experience + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department=" + department +
                '}';
    }
}

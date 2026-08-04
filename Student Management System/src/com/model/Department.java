package com.model;

//Record Class
public record Department(String departmentId, String departmentName, String hodName) {

    @Override
    public String toString() {
        return "Department ID : " + departmentId +
                "\nDepartment Name : " + departmentName +
                "\nHOD : " + hodName;
    }
}

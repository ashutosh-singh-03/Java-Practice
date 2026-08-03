package com.model;

//Record Class
public record Department(int departmentId, String departmentName, String hodName, String location) {

    @Override
    public String toString() {
        return "Department ID : " + departmentId +
                "\nDepartment Name : " + departmentName +
                "\nHOD : " + hodName +
                "\nLocation : " + location;
    }
}

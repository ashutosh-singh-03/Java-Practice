package com.service;

import com.model.Department;

import java.util.ArrayList;

public class DepartmentService {
    private final ArrayList<Department> departments;

    public DepartmentService() {
        departments = new ArrayList<>();
    }

    public boolean addDepartment(Department department) {
        if (department == null) return false;
        else if (searchDepartmentById(department.departmentId()) != null) return false;
        departments.add(department);
        return true;
    }

    public boolean removeDepartment(String id) {
        Department department = searchDepartmentById(id);
        if (department == null) return false;
        departments.remove(department);
        return true;
    }

    public boolean updateDepartment(String id, String newName, String newHod) {
        Department oldDepartment = searchDepartmentById(id);
        if (oldDepartment == null) return false;
        departments.remove(oldDepartment);

        Department updatedDepartment = new Department(id, newName, newHod);
        departments.add(updatedDepartment);
        return true;
    }

    public Department searchDepartmentById(String id) {
        for (Department department : departments) {
            if (department.departmentId().equalsIgnoreCase(id)) return department;
        }
        return null;
    }

    public ArrayList<Department> getAllDepartments() {
        return new ArrayList<>(departments);
    }
}

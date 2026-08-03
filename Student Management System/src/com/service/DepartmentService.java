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
        else if (searchDepartment(department.departmentId()) != null) return false;
        departments.add(department);
        return true;
    }

    public boolean removeDepartment(int id) {
        Department department = searchDepartment(id);
        if (department == null) return false;
        departments.remove(department);
        return true;
    }

    public boolean updateDepartment(int id, String newName, String newHod, String newLocation) {
        Department oldDepartment = searchDepartment(id);
        if (oldDepartment == null) return false;
        departments.remove(oldDepartment);

        Department updatedDepartment = new Department(id, newName, newHod, newLocation);
        departments.add(updatedDepartment);
        return true;
    }

    public Department searchDepartment(int id) {
        for (Department department : departments) {
            if (department.departmentId() == id) return department;
        }
        return null;
    }

    public ArrayList<Department> getAllDepartments() {
        return departments;
    }
}

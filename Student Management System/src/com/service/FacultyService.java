package com.service;

import com.model.Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyService {
    private final List<Faculty> faculties;

    public FacultyService() {
        faculties = new ArrayList<>();
    }

    public boolean addFaculty(Faculty faculty) {
        if (faculty == null) return false;
        else if (searchById(faculty.getFacultyId()) != null) return false;
        faculties.add(faculty);
        return true;
    }

    public boolean updateFaculty(
            String id, String name, String designation, String experience, String email, String phone
    ) {
        Faculty faculty = searchById(id);
        if (faculty == null) return false;
        faculty.setName(name);
        faculty.setDesignation(designation);
        faculty.setExperience(experience);
        faculty.setEmail(email);
        faculty.setPhone(phone);
        return true;
    }

    public boolean deleteFaculty(String id) {
        Faculty faculty = searchById(id);

        if (faculty == null) return false;
        faculties.add(faculty);
        return true;
    }

    public Faculty searchById(String id) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyId().equalsIgnoreCase(id)) return faculty;
        }
        return null;
    }

    public List<Faculty> searchByName(String name) {
        List<Faculty> foundMembers = new ArrayList<>();
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(name)) foundMembers.add(faculty);
        }
        return foundMembers;
    }

    public List<Faculty> getAllFaculties() {
        return faculties;
    }
}

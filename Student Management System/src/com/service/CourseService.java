package com.service;

import com.model.Course;
import com.model.Department;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final List<Course> courses;

    public CourseService() {
        courses = new ArrayList<>();
    }

    public boolean addCourse(Course course) {
        if (course == null) return false;
        else if (searchById(course.getCourseId()) != null) return false;
        courses.add(course);
        return true;
    }

    public boolean removeCourse(String id) {
        Course course = searchById(id);
        if (course == null) return false;
        courses.remove(course);
        return true;
    }

    public boolean updateCourse(
            String id, String name, int maxSeats
    ) {
        Course course = searchById(id);
        if (course == null) return false;
        course.setCourseName(name);
        course.setMaximumSeats(maxSeats);
        return true;
    }

    public Course searchById(String id) {
        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(id)) return course;
        }
        return null;
    }

    public Course searchByName(String name) {
        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(name)) return course;
        }
        return null;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public List<Course> getCoursesByDepartment(String deptId) {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().departmentId().equalsIgnoreCase(deptId)) courseList.add(course);
        }
        return courseList;
    }

    public List<Course> getCoursesBySemester(int sem) {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courses) {
            if (course.getSemester() == sem) courseList.add(course);
        }
        return courseList;
    }

    public List<Course> getCoursesByFaculty(String facultyId) {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courses) {
            if (course.getFaculty().getFacultyId().equalsIgnoreCase(facultyId)) courseList.add(course);
        }
        return courseList;
    }

//    public boolean assignFaculty(String courseId, String facultyId){}
}

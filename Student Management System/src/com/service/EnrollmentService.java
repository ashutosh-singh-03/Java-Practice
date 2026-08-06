package com.service;

import com.model.Course;
import com.model.Enrollment;
import com.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final List<Enrollment> enrollments;

    public EnrollmentService() {
        enrollments = new ArrayList<>();
    }

    public boolean addEnrollment(String id, Student student, Course course) {
        if (student == null || course == null) return false;
        else if (isAlreadyEnrolled(student.getStudentId(), course.getCourseId())) return false;
        enrollments.add(new Enrollment(id, student, course, LocalDate.now()));
        return true;
    }


    public boolean removeEnrollment(String enrollmentId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId().equalsIgnoreCase(enrollmentId)) {
                enrollments.remove(enrollment);
                return true;
            }
        }
        return false;
    }

    public Enrollment searchEnrollmentById(String enrollmentId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId().equalsIgnoreCase(enrollmentId)) return enrollment;
        }
        return null;
    }

    public List<Course> getCoursesByStudent(String studentId) {
        List<Course> courseList = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getStudentId().equalsIgnoreCase(studentId))
                courseList.add(enrollment.getCourse());
        }

        return courseList;
    }

    public List<Student> getStudentsByCourse(String courseId) {
        List<Student> studentList = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().getCourseId().equalsIgnoreCase(courseId))
                studentList.add(enrollment.getStudent());
        }

        return studentList;
    }

    public boolean isAlreadyEnrolled(String studentId, String courseId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getStudentId().equalsIgnoreCase(studentId) &&
                    enrollment.getCourse().getCourseId().equalsIgnoreCase(courseId)) return true;
        }
        return false;
    }

    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
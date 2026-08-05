package com.model;

import com.enums.Attendance;

import java.time.LocalDate;

public class AttendanceRecord {
    private final String attendanceId;
    private Student student;
    private Course course;
    private LocalDate date;
    private Attendance status;

    public AttendanceRecord(
            String attendanceId, Student student, Course course, LocalDate date, Attendance status
    ) {
        this.attendanceId = attendanceId;
        this.student = student;
        this.course = course;
        this.date = date;
        this.status = status;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Attendance getStatus() {
        return status;
    }

    public void setStatus(Attendance status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "attendanceId='" + attendanceId + '\'' +
                ", student=" + student +
                ", course=" + course +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}

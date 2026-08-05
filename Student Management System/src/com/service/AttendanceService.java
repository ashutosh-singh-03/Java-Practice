package com.service;

import com.enums.Attendance;
import com.model.AttendanceRecord;
import com.model.Course;
import com.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private final List<AttendanceRecord> attendances;

    public AttendanceService() {
        attendances = new ArrayList<>();
    }

    public boolean markAttendance(
            String attendanceId, Student student, Course course, LocalDate date, Attendance status
    ) {
        if (student == null || course == null || date == null || status == null) return false;
        else if (searchAttendanceById(attendanceId) != null) return false;
        else if (isAttendanceAlreadyMarked(student.getStudentId(), course.getCourseId(), date)) return false;
        attendances.add(new AttendanceRecord(attendanceId, student, course, date, status));
        return true;
    }

    public boolean isAttendanceAlreadyMarked(String studentId, String courseId, LocalDate date) {
        for (AttendanceRecord attendance : attendances) {
            if (attendance.getStudent().getStudentId().equalsIgnoreCase(studentId)
                    && attendance.getCourse().getCourseId().equalsIgnoreCase(courseId)
                    && attendance.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean updateAttendance(String attendanceId, Attendance newStatus) {
        AttendanceRecord attendance = searchAttendanceById(attendanceId);

        if (attendance == null || newStatus == null) return false;
        attendance.setStatus(newStatus);
        return true;
    }

    public AttendanceRecord searchAttendanceById(String attendanceId) {
        for (AttendanceRecord attendance : attendances) {
            if (attendance.getAttendanceId().equalsIgnoreCase(attendanceId)) return attendance;
        }
        return null;
    }

    public List<AttendanceRecord> getAttendanceByStudent(String studentId) {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        for (AttendanceRecord attendance : attendances) {
            if (attendance.getStudent().getStudentId().equalsIgnoreCase(studentId)) attendanceRecords.add(attendance);
        }
        return attendanceRecords;
    }

    public List<AttendanceRecord> getAttendanceByCourse(String courseId) {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        for (AttendanceRecord attendance : attendances) {
            if (attendance.getCourse().getCourseId().equalsIgnoreCase(courseId)) attendanceRecords.add(attendance);
        }
        return attendanceRecords;
    }

    public List<AttendanceRecord> getAttendanceByDate(LocalDate date) {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        for (AttendanceRecord attendance : attendances) {
            if (attendance.getDate().equals(date)) attendanceRecords.add(attendance);
        }
        return attendanceRecords;
    }

    public List<AttendanceRecord> getAllAttendance() {
        return new ArrayList<>(attendances);
    }
}

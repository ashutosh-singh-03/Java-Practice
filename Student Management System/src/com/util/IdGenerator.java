package com.util;

public class IdGenerator {
    private static int departmentCount = 1;
    private static int facultyCount = 1;
    private static int courseCount = 1;
    private static int studentCount = 1;
    private static int attendanceCount = 1;
    private static int enrollmentCount = 1;
    private static int gradeCount = 1;

    public static String generateDepartmentId() {
        return "D" + departmentCount++;
    }

    public static String generateFacultyId() {
        return "D" + facultyCount++;
    }

    public static String generateCourseId() {
        return "D" + courseCount++;
    }

    public static String generateStudentId() {
        return "D" + studentCount++;
    }

    public static String generateAttendanceId() {
        return "D" + attendanceCount++;
    }

    public static String generateEnrollmentId() {
        return "D" + enrollmentCount++;
    }

    public static String generateGradeRecordId() {
        return "D" + gradeCount++;
    }
}

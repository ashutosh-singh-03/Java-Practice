package com.app;

import com.service.*;
import com.util.MenuUtil;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final DepartmentService departmentService = new DepartmentService();
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final FacultyService facultyService = new FacultyService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final AttendanceService attendanceService = new AttendanceService();
    private static final GradeService gradeService = new GradeService();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            MenuUtil.printMainMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> manageDepartment();
                case 2 -> manageFaculties();
                case 3 -> manageCourses();
                case 4 -> manageStudents();
                case 5 -> manageEnrollments();
                case 6 -> manageAttendance();
                case 7 -> manageGrades();
                case 0 -> running = false;
                default -> System.out.println("Invalid Choice");
            }
        }
        System.out.println("Thank You for using Student Management System.");
    }

    public static void manageDepartment() {
    }

    public static void manageFaculties() {
    }

    public static void manageCourses() {
    }

    public static void manageStudents() {
    }

    public static void manageEnrollments() {
    }

    public static void manageAttendance() {
    }

    public static void manageGrades() {
    }

    public static int readInt() {
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static float readFloat() {
        float value = sc.nextFloat();
        sc.nextLine();
        return value;
    }
}
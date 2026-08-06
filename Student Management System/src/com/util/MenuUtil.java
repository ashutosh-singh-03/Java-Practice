package com.util;

public class MenuUtil {
    public static void printMainMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Departments");
        System.out.println("2. Faculties");
        System.out.println("3. Courses");
        System.out.println("4. Students");
        System.out.println("5. Enrollments");
        System.out.println("6. Attendance");
        System.out.println("7. Grades");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    public static void printCrudMenu(String title) {
        System.out.println("\n===== " + title + " =====");
        System.out.println("1. Add");
        System.out.println("2. View All");
        System.out.println("3. Search By ID");
        System.out.println("4. Delete");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");
    }
}

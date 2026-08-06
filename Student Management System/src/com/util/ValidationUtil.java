package com.util;

import com.model.Student;

import java.time.LocalDate;

public class ValidationUtil {

    public static boolean isValidStudentAge(Student student) {
        return student != null && student.getAge() >= 18 && student.getAge() <= 25;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        phone = phone.trim();
        if (phone.length() != 10) return false;

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) return false;
        }
        return true;
    }

    public static boolean isValidCgpa(float cgpa) {
        return cgpa >= 0 && cgpa <= 10;
    }

    public static boolean isValidSemester(int semester) {
        return semester >= 1 && semester <= 8;
    }

    public static boolean isValidDate(LocalDate date) {
        return date != null;
    }

    public static boolean isValidTotalMarks(float marks) {
        return marks >= 0 && marks <= 100;
    }

    public static boolean isValidInternalMarks(float internalMarks) {
        return internalMarks >= 0 && internalMarks <= 60;
    }

    public static boolean isValidExternalMarks(float externalMarks) {
        return externalMarks >= 0 && externalMarks <= 40;
    }
}

# Student Management System

A simple Java-based console application for managing student-related academic records. The project is designed to help organize basic university data such as departments, faculty, courses, and students in one place.

## Overview

This system focuses on core academic management tasks. It allows you to create and maintain records for different entities in the institution and perform basic searches and updates without relying on a database.

## Current Features

The project currently supports the following features:

- Manage academic departments
- Manage faculty members
- Manage courses
- Manage students
- Add and update student personal and academic details
- Search students by ID, name, department, or semester
- View all students or filter them by department and semester
- View students sorted by name or CGPA
- Graduate a student when they meet the required semester level
- Search courses by department, semester, or faculty

## Project Structure

```text
Student Management System/
├── src/
│   └── com/
│       ├── app/
│       │   └── Main.java
│       ├── enums/
│       │   ├── Attendance.java
│       │   ├── Designation.java
│       │   ├── Gender.java
│       │   ├── Grade.java
│       │   └── StudentStatus.java
│       ├── model/
│       │   ├── AttendanceRecord.java
│       │   ├── Course.java
│       │   ├── Department.java
│       │   ├── Enrollment.java
│       │   ├── Faculty.java
│       │   ├── GradeRecord.java
│       │   └── Student.java
│       ├── service/
│       │   ├── CourseService.java
│       │   ├── DepartmentService.java
│       │   ├── FacultyService.java
│       │   └── StudentService.java
│       └── util/
│           ├── FileUtil.java
│           ├── IdGenerator.java
│           ├── MenuUtil.java
│           └── ValidationUtil.java
```

## How to Run

1. Open the project in a Java IDE such as IntelliJ IDEA or VS Code.
2. Navigate to the source folder.
3. Run the Main class from src/com/app/Main.java.

## Notes

This README is intentionally simple and will be updated as more features are added to the project.

package com.service;

import com.enums.StudentStatus;
import com.model.Department;
import com.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentService {
    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (student == null) return false;
        else if (searchStudentById(student.getStudentId()) != null) {
            System.out.println("Student already exists.");
            return false;
        }
        students.add(student);
        return true;
    }

    public boolean updateStudent(String id, String newName, String newMail, String newPhone,
                                 Department newDepartment, int newSemester, float newCgpa, StudentStatus newStatus) {
        Student student = searchStudentById(id);
        if (student == null) {
            System.out.println("Student not Found!");
            return false;
        }
        student.setName(newName);
        student.setEmail(newMail);
        student.setPhone(newPhone);
        student.setDepartment(newDepartment);
        student.setSemester(newSemester);
        student.setCgpa(newCgpa);
        student.setStatus(newStatus);
        return true;
    }

    public boolean deleteStudent(String id) {
        Student student = searchStudentById(id);

        if (student == null) {
            System.out.println("No student found!");
            return false;
        }
        students.remove(student);
        return true;
    }

    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(id)) return student;
        }
        return null;
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) foundStudents.add(student);
        }
        return foundStudents;
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public ArrayList<Student> getStudentByDepartment(String departmentName) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getDepartment().departmentName().equalsIgnoreCase(departmentName))
                foundStudents.add(student);
        }
        return foundStudents;
    }

    public ArrayList<Student> getStudentBySemester(int semester) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getSemester() == semester) foundStudents.add(student);
        }
        return foundStudents;
    }

    public ArrayList<Student> displayStudentSortedByName() {
        ArrayList<Student> sortedStudent = new ArrayList<>(students);
        sortedStudent.sort(Comparator.comparing(Student::getName));

        return sortedStudent;
    }

    public ArrayList<Student> displayStudentSortedByCGPA() {
        ArrayList<Student> sorted = new ArrayList<>(students);
        sorted.sort(
                Comparator.comparingDouble(Student::getCgpa).reversed()
        );
        return sorted;
    }
}

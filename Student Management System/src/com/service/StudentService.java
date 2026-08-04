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

    public boolean updateAcademicDetails(
            String id, Department newDepartment, int newSemester, float newCgpa
    ) {
        Student student = searchStudentById(id);
        if (student == null) return false;

        student.setDepartment(newDepartment);
        student.setSemester(newSemester);
        student.setCgpa(newCgpa);
        return true;
    }

    public boolean updatePersonalDetails(
            String id, String newName, String newMail, String newPhone
    ) {
        Student student = searchStudentById(id);
        if (student == null) return false;

        student.setName(newName);
        student.setEmail(newMail);
        student.setPhone(newPhone);
        return true;
    }

    public boolean deleteStudent(String id) {
        Student student = searchStudentById(id);

        if (student == null) return false;
        students.remove(student);
        return true;
    }

    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(id)) return student;
        }
        return null;
    }

    public List<Student> searchStudentByName(String name) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) foundStudents.add(student);
        }
        return foundStudents;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> getStudentByDepartment(String departmentName) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getDepartment().departmentName().equalsIgnoreCase(departmentName))
                foundStudents.add(student);
        }
        return foundStudents;
    }

    public List<Student> getStudentBySemester(int semester) {
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getSemester() == semester) foundStudents.add(student);
        }
        return foundStudents;
    }

    public List<Student> getStudentSortedByName() {
        List<Student> sortedStudent = new ArrayList<>(students);
        sortedStudent.sort(Comparator.comparing(Student::getName));

        return sortedStudent;
    }

    public List<Student> getStudentSortedByCGPA() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(
                Comparator.comparingDouble(Student::getCgpa).reversed()
        );
        return sorted;
    }

    public boolean graduateStudent(String id) {
        Student student = searchStudentById(id);

        if (student == null) return false;
        if (student.getSemester() < 8) return false;

        student.graduate();
        return true;
    }
}

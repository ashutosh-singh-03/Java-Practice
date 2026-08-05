package com.service;

import com.enums.Grade;
import com.model.Course;
import com.model.GradeRecord;
import com.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GradeService {
    private final List<GradeRecord> grades;

    public GradeService() {
        grades = new ArrayList<>();
    }

    public boolean addGradeRecord(
            String recordId, Student student, Course course, float internalMarks, float externalMarks
    ) {
        if (recordId == null || student == null || course == null) return false;
        else if (internalMarks < 0 || externalMarks < 0) return false;
        else if (searchGradeRecordById(recordId) != null) return false;
        else if (isGradeAlreadyAdded(student.getStudentId(), course.getCourseId())) return false;
        grades.add(new GradeRecord(recordId, student, course, internalMarks, externalMarks));
        return true;
    }

    public boolean isGradeAlreadyAdded(String studentId, String courseId) {
        for (GradeRecord grade : grades) {
            if (grade.getStudent().getStudentId().equalsIgnoreCase(studentId)
                    && grade.getCourse().getCourseId().equalsIgnoreCase(courseId)) return true;
        }
        return false;
    }

    public boolean updateMarks(String recordId, float internalMarks, float externalMarks) {
        GradeRecord grade = searchGradeRecordById(recordId);

        if (grade == null || internalMarks < 0 || externalMarks < 0) return false;
        grade.setInternalMarks(internalMarks);
        grade.setExternalMarks(externalMarks);
        return true;
    }

    public GradeRecord searchGradeRecordById(String recordId) {
        for (GradeRecord grade : grades) {
            if (grade.getRecordId().equalsIgnoreCase(recordId)) return grade;
        }
        return null;
    }

    public List<GradeRecord> getGradesByStudent(String studentId) {
        List<GradeRecord> gradeRecords = new ArrayList<>();
        for (GradeRecord gradeRecord : grades) {
            if (gradeRecord.getStudent().getStudentId().equalsIgnoreCase(studentId)) gradeRecords.add(gradeRecord);
        }
        return gradeRecords;
    }

    public List<GradeRecord> getGradesByCourse(String courseId) {
        List<GradeRecord> gradeRecords = new ArrayList<>();
        for (GradeRecord gradeRecord : grades) {
            if (gradeRecord.getCourse().getCourseId().equalsIgnoreCase(courseId)) gradeRecords.add(gradeRecord);
        }
        return gradeRecords;
    }

    public float calculateTotalMarks(String recordId) {
        GradeRecord gradeRecord = searchGradeRecordById(recordId);

        if (gradeRecord == null) {
            return 0;
        }
        return gradeRecord.getInternalMarks() + gradeRecord.getExternalMarks();

    }

    public Grade calculateGrade(String recordId) {
        GradeRecord gradeRecord = searchGradeRecordById(recordId);

        if (gradeRecord == null) return null;

        float marks = gradeRecord.getInternalMarks() + gradeRecord.getExternalMarks();

        if (marks >= 90) return Grade.A_PLUS;
        else if (marks >= 80) return Grade.A;
        else if (marks >= 70) return Grade.B_PLUS;
        else if (marks >= 60) return Grade.B;
        else if (marks >= 50) return Grade.C;
        else if (marks >= 40) return Grade.D;
        else return Grade.F;
    }

    public List<GradeRecord> getAllGradeRecords() {
        return new ArrayList<>(grades);
    }
}
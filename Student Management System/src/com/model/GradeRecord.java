package com.model;

public class GradeRecord {
    private final String recordId;
    private Student student;
    private Course course;
    private float internalMarks;
    private float externalMarks;

    public GradeRecord(
            String recordId, Student student, Course course, float internalMarks, float externalMarks
    ) {
        this.recordId = recordId;
        this.student = student;
        this.course = course;
        this.internalMarks = internalMarks;
        this.externalMarks = externalMarks;
    }

    public String getRecordId() {
        return recordId;
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

    public float getInternalMarks() {
        return internalMarks;
    }

    public void setInternalMarks(float internalMarks) {
        this.internalMarks = internalMarks;
    }

    public float getExternalMarks() {
        return externalMarks;
    }

    public void setExternalMarks(float externalMarks) {
        this.externalMarks = externalMarks;
    }

    @Override
    public String toString() {
        return "GradeRecord{" +
                "recordId='" + recordId + '\'' +
                ", student=" + student +
                ", course=" + course +
                ", internalMarks=" + internalMarks +
                ", externalMarks=" + externalMarks +
                '}';
    }
}

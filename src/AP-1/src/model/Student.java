package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String rollNumber;
    private String admissionNumber;
    private String program;
    private String division;
    private int currentSemester;
    private List<String> completedCourses;
    private List<String> registeredCourses;
    private List<String> grades;
    private List<Complaint> complaints;
    private List<Enrollment> enrollments;

    public Student(
            String id,
            String name,
            String email,
            String password,
            String department,
            String rollNumber,
            String admissionNumber,
            String program,
            String division,
            int currentSemester) {
        super(id, name, email, password, department);
        this.rollNumber = rollNumber;
        this.admissionNumber = admissionNumber;
        this.program = program;
        this.division = division;
        this.currentSemester = currentSemester;
        this.completedCourses = new ArrayList<>();
        this.registeredCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public List<String> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(List<String> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public void addCompletedCourse(String courseCode) {
        if (!completedCourses.contains(courseCode)) {
            completedCourses.add(courseCode);
        }
    }

    public void addRegisteredCourse(String courseCode) {
        if (!registeredCourses.contains(courseCode)) {
            registeredCourses.add(courseCode);
        }
    }

    public void dropRegisteredCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    public void addGrade(String grade) {
        grades.add(grade);
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public Enrollment findEnrollment(String courseCode) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseCode().equalsIgnoreCase(courseCode)) {
                return enrollment;
            }
        }
        return null;
    }

    public List<Enrollment> getActiveEnrollments() {
        List<Enrollment> activeEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.isActive()) {
                activeEnrollments.add(enrollment);
            }
        }
        return activeEnrollments;
    }

    public List<Enrollment> getCompletedEnrollments() {
        List<Enrollment> completedEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.isCompleted()) {
                completedEnrollments.add(enrollment);
            }
        }
        return completedEnrollments;
    }

    @Override
    public String getRoleName() {
        return "Student";
    }

    @Override
    public String showBasicProfile() {
        return "Student ID: " + getId()
                + ", Name: " + getName()
                + ", Roll No: " + rollNumber
                + ", Semester: " + currentSemester
                + ", Program: " + program;
    }
}

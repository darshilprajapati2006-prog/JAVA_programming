package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String title;
    private String professor;
    private int credits;
    private List<String> prerequisites;
    private List<ScheduleSlot> timings;
    private String location;
    private String syllabus;
    private int enrollmentLimit;
    private List<String> enrolledStudents;
    private int semester;

    public Course(
            String courseCode,
            String title,
            String professor,
            int credits,
            String location,
            String syllabus,
            int enrollmentLimit,
            int semester) {
        this.courseCode = courseCode;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = new ArrayList<>();
        this.timings = new ArrayList<>();
        this.location = location;
        this.syllabus = syllabus;
        this.enrollmentLimit = enrollmentLimit;
        this.enrolledStudents = new ArrayList<>();
        this.semester = semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<ScheduleSlot> getTimings() {
        return timings;
    }

    public void setTimings(List<ScheduleSlot> timings) {
        this.timings = timings;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) {
            prerequisites.add(courseCode);
        }
    }

    public void addTiming(ScheduleSlot slot) {
        timings.add(slot);
    }

    public boolean addStudent(String studentId) {
        if (isFull() || enrolledStudents.contains(studentId)) {
            return false;
        }
        enrolledStudents.add(studentId);
        return true;
    }

    public boolean removeStudent(String studentId) {
        return enrolledStudents.remove(studentId);
    }

    public boolean isFull() {
        return enrolledStudents.size() >= enrollmentLimit;
    }

    public String displayCourseInfo() {
        return courseCode + " - " + title
                + " | Professor: " + professor
                + " | Credits: " + credits
                + " | Semester: " + semester
                + " | Location: " + location;
    }
}

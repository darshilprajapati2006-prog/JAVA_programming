package model;

import java.time.LocalDate;

public class Enrollment {
    private String studentId;
    private String courseCode;
    private int semester;
    private String grade;
    private String status;
    private LocalDate registrationDate;
    private LocalDate dropDeadline;

    public Enrollment(String studentId, String courseCode, int semester) {
        this(studentId, courseCode, semester, LocalDate.now(), LocalDate.now().plusDays(7));
    }

    public Enrollment(
            String studentId,
            String courseCode,
            int semester,
            LocalDate registrationDate,
            LocalDate dropDeadline) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.grade = "";
        this.status = "REGISTERED";
        this.registrationDate = registrationDate;
        this.dropDeadline = dropDeadline;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getDropDeadline() {
        return dropDeadline;
    }

    public void setDropDeadline(LocalDate dropDeadline) {
        this.dropDeadline = dropDeadline;
    }

    public void markCompleted(String grade) {
        this.grade = grade;
        this.status = "COMPLETED";
    }

    public void markDropped() {
        this.status = "DROPPED";
    }

    public boolean isCompleted() {
        return "COMPLETED".equalsIgnoreCase(status);
    }

    public boolean isActive() {
        return "REGISTERED".equalsIgnoreCase(status);
    }

    public boolean isDropDeadlinePassed() {
        return dropDeadline != null && LocalDate.now().isAfter(dropDeadline);
    }
}

package model;

public class Enrollment {
    private String studentId;
    private String courseCode;
    private int semester;
    private String grade;
    private String status;

    public Enrollment(String studentId, String courseCode, int semester) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.grade = "";
        this.status = "REGISTERED";
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
}

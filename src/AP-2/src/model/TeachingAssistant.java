package model;

import java.util.ArrayList;
import java.util.List;

public class TeachingAssistant extends Student {
    private String taId;
    private String supervisingProfessorName;
    private List<String> assistingCourseCodes;

    public TeachingAssistant(
            String id,
            String name,
            String email,
            String password,
            String department,
            String rollNumber,
            String admissionNumber,
            String program,
            String division,
            int currentSemester,
            String taId,
            String supervisingProfessorName) {
        super(id, name, email, password, department, rollNumber, admissionNumber, program, division, currentSemester);
        this.taId = taId;
        this.supervisingProfessorName = supervisingProfessorName;
        this.assistingCourseCodes = new ArrayList<>();
    }

    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }

    public String getSupervisingProfessorName() {
        return supervisingProfessorName;
    }

    public void setSupervisingProfessorName(String supervisingProfessorName) {
        this.supervisingProfessorName = supervisingProfessorName;
    }

    public List<String> getAssistingCourseCodes() {
        return assistingCourseCodes;
    }

    public void setAssistingCourseCodes(List<String> assistingCourseCodes) {
        this.assistingCourseCodes = assistingCourseCodes;
    }

    public void assignCourseForAssistance(String courseCode) {
        if (!assistingCourseCodes.contains(courseCode)) {
            assistingCourseCodes.add(courseCode);
        }
    }

    public void removeCourseFromAssistance(String courseCode) {
        assistingCourseCodes.remove(courseCode);
    }

    public boolean canManageGradesFor(String courseCode) {
        return assistingCourseCodes.contains(courseCode);
    }

    @Override
    public String getRoleName() {
        return "Teaching Assistant";
    }

    @Override
    public String showBasicProfile() {
        return "TA ID: " + taId
                + ", Name: " + getName()
                + ", Roll No: " + getRollNumber()
                + ", Semester: " + getCurrentSemester()
                + ", Supervising Professor: " + supervisingProfessorName;
    }
}

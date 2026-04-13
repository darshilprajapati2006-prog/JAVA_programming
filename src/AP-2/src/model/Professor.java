package model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
    private String facultyId;
    private String expertise;
    private List<String> assignedCourses;
    private String officeRoom;
    private String officeHours;

    public Professor(
            String id,
            String name,
            String email,
            String password,
            String department,
            String facultyId,
            String expertise,
            String officeRoom,
            String officeHours) {
        super(id, name, email, password, department);
        this.facultyId = facultyId;
        this.expertise = expertise;
        this.assignedCourses = new ArrayList<>();
        this.officeRoom = officeRoom;
        this.officeHours = officeHours;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public List<String> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(List<String> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public String getOfficeRoom() {
        return officeRoom;
    }

    public void setOfficeRoom(String officeRoom) {
        this.officeRoom = officeRoom;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void assignCourse(String courseCode) {
        if (!assignedCourses.contains(courseCode)) {
            assignedCourses.add(courseCode);
        }
    }

    public void removeAssignedCourse(String courseCode) {
        assignedCourses.remove(courseCode);
    }

    @Override
    public String getRoleName() {
        return "Professor";
    }

    @Override
    public String showBasicProfile() {
        return "Professor ID: " + facultyId
                + ", Name: " + getName()
                + ", Expertise: " + expertise
                + ", Office Hours: " + officeHours;
    }
}

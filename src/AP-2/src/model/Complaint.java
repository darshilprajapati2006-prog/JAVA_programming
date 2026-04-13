package model;

import java.time.LocalDate;

public class Complaint {
    private String complaintId;
    private String studentId;
    private String studentName;
    private String title;
    private String description;
    private String status;
    private String dateRaised;
    private String resolutionNote;

    public Complaint(
            String complaintId,
            String studentId,
            String studentName,
            String title,
            String description,
            String status,
            String dateRaised,
            String resolutionNote) {
        this.complaintId = complaintId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateRaised = dateRaised;
        this.resolutionNote = resolutionNote;
    }

    public Complaint(String complaintId, String studentId, String studentName, String title, String description) {
        this(complaintId, studentId, studentName, title, description, "PENDING", LocalDate.now().toString(), "");
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return dateRaised;
    }

    public void setDate(String date) {
        this.dateRaised = date;
    }

    public String getResolutionDetails() {
        return resolutionNote;
    }

    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionNote = resolutionDetails;
    }

    public void markResolved(String resolutionDetails) {
        this.status = "RESOLVED";
        this.resolutionNote = resolutionDetails;
    }

    public String displayComplaint() {
        return "Complaint ID: " + complaintId
                + " | Student: " + studentName + " (" + studentId + ")"
                + " | Title: " + title
                + " | Status: " + status
                + " | Date: " + dateRaised
                + " | Description: " + description
                + " | Resolution: " + (resolutionNote == null || resolutionNote.isEmpty() ? "Pending" : resolutionNote);
    }
}

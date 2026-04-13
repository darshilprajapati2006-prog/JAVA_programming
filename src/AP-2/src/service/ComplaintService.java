package service;

import java.util.ArrayList;
import java.util.List;

import data.UniversityDataStore;
import model.Complaint;
import model.Student;

public class ComplaintService {
    private final UniversityDataStore dataStore;

    public ComplaintService(UniversityDataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Complaint createComplaint(Student student, String title, String description) {
        String complaintId = String.format("CMP%03d", dataStore.getComplaints().size() + 1);
        Complaint complaint = new Complaint(
                complaintId,
                student.getId(),
                student.getName(),
                title,
                description);
        dataStore.addComplaint(complaint);
        return complaint;
    }

    public List<Complaint> getStudentComplaints(String studentId) {
        return dataStore.findComplaintsByStudentId(studentId);
    }

    public List<Complaint> getAllComplaints() {
        return dataStore.getComplaints();
    }

    public List<Complaint> filterByStatus(String status) {
        List<Complaint> filteredComplaints = new ArrayList<>();
        for (Complaint complaint : dataStore.getComplaints()) {
            if (complaint.getStatus().equalsIgnoreCase(status)) {
                filteredComplaints.add(complaint);
            }
        }
        return filteredComplaints;
    }

    public List<Complaint> filterByDate(String date) {
        List<Complaint> filteredComplaints = new ArrayList<>();
        for (Complaint complaint : dataStore.getComplaints()) {
            if (complaint.getDate().equalsIgnoreCase(date)) {
                filteredComplaints.add(complaint);
            }
        }
        return filteredComplaints;
    }

    public boolean resolveComplaint(String complaintId, String resolutionDetails) {
        Complaint complaint = dataStore.findComplaintById(complaintId);
        if (complaint == null) {
            return false;
        }
        complaint.markResolved(resolutionDetails);
        return true;
    }
}

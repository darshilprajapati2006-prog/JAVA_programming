package data;

import java.util.ArrayList;
import java.util.List;

import model.Administrator;
import model.Complaint;
import model.Course;
import model.Professor;
import model.Student;

public class UniversityDataStore extends DataStore {
    public Student findStudentById(String studentId) {
        for (Student student : getStudents()) {
            if (student.getId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public Student findStudentByEmail(String email) {
        for (Student student : getStudents()) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    public Student findStudentByRollNumber(String rollNumber) {
        for (Student student : getStudents()) {
            if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public Professor findProfessorById(String professorId) {
        for (Professor professor : getProfessors()) {
            if (professor.getId().equalsIgnoreCase(professorId)
                    || professor.getFacultyId().equalsIgnoreCase(professorId)) {
                return professor;
            }
        }
        return null;
    }

    public Professor findProfessorByEmail(String email) {
        for (Professor professor : getProfessors()) {
            if (professor.getEmail().equalsIgnoreCase(email)) {
                return professor;
            }
        }
        return null;
    }

    public Administrator findAdministratorById(String adminId) {
        for (Administrator administrator : getAdministrators()) {
            if (administrator.getId().equalsIgnoreCase(adminId)
                    || administrator.getAdminId().equalsIgnoreCase(adminId)) {
                return administrator;
            }
        }
        return null;
    }

    public Administrator findAdministratorByEmail(String email) {
        for (Administrator administrator : getAdministrators()) {
            if (administrator.getEmail().equalsIgnoreCase(email)) {
                return administrator;
            }
        }
        return null;
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : getCourses()) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public Complaint findComplaintById(String complaintId) {
        for (Complaint complaint : getComplaints()) {
            if (complaint.getComplaintId().equalsIgnoreCase(complaintId)) {
                return complaint;
            }
        }
        return null;
    }

    public List<Course> findCoursesBySemester(int semester) {
        List<Course> semesterCourses = new ArrayList<>();
        for (Course course : getCourses()) {
            if (course.getSemester() == semester) {
                semesterCourses.add(course);
            }
        }
        return semesterCourses;
    }

    public List<Course> findCoursesByProfessor(String professorName) {
        List<Course> assignedCourses = new ArrayList<>();
        for (Course course : getCourses()) {
            if (course.getProfessor().equalsIgnoreCase(professorName)) {
                assignedCourses.add(course);
            }
        }
        return assignedCourses;
    }

    public List<Complaint> findComplaintsByStudentId(String studentId) {
        List<Complaint> studentComplaints = new ArrayList<>();
        for (Complaint complaint : getComplaints()) {
            if (complaint.getStudentId().equalsIgnoreCase(studentId)) {
                studentComplaints.add(complaint);
            }
        }
        return studentComplaints;
    }

    public List<Complaint> findComplaintsByStatus(String status) {
        List<Complaint> filteredComplaints = new ArrayList<>();
        for (Complaint complaint : getComplaints()) {
            if (complaint.getStatus().equalsIgnoreCase(status)) {
                filteredComplaints.add(complaint);
            }
        }
        return filteredComplaints;
    }

    public List<Complaint> findComplaintsByDate(String date) {
        List<Complaint> filteredComplaints = new ArrayList<>();
        for (Complaint complaint : getComplaints()) {
            if (complaint.getDate().equalsIgnoreCase(date)) {
                filteredComplaints.add(complaint);
            }
        }
        return filteredComplaints;
    }

    public boolean containsStudentEmail(String email) {
        return findStudentByEmail(email) != null;
    }

    public boolean containsProfessorEmail(String email) {
        return findProfessorByEmail(email) != null;
    }

    public boolean containsAdministratorEmail(String email) {
        return findAdministratorByEmail(email) != null;
    }

    public boolean containsCourseCode(String courseCode) {
        return findCourseByCode(courseCode) != null;
    }
}

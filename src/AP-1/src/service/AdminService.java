package service;

import java.util.List;

import data.UniversityDataStore;
import model.Complaint;
import model.Course;
import model.Enrollment;
import model.Professor;
import model.Student;
import util.GradeUtil;

public class AdminService {
    private final UniversityDataStore dataStore;
    private final CourseService courseService;
    private final ComplaintService complaintService;

    public AdminService(
            UniversityDataStore dataStore,
            CourseService courseService,
            ComplaintService complaintService) {
        this.dataStore = dataStore;
        this.courseService = courseService;
        this.complaintService = complaintService;
    }

    public List<Course> viewAllCourses() {
        return courseService.listAllCourses();
    }

    public boolean addCourse(Course course) {
        return courseService.addCourse(course);
    }

    public boolean deleteCourse(String courseCode) {
        return courseService.deleteCourse(courseCode);
    }

    public boolean assignProfessorToCourse(String courseCode, String professorId) {
        Professor professor = dataStore.findProfessorById(professorId);
        return courseService.assignProfessor(courseCode, professor);
    }

    public List<Student> viewAllStudentRecords() {
        return dataStore.getStudents();
    }

    public boolean updateStudentSemester(String studentId, int semester) {
        Student student = dataStore.findStudentById(studentId);
        if (student == null) {
            return false;
        }
        student.setCurrentSemester(semester);
        return true;
    }

    public boolean updateStudentName(String studentId, String newName) {
        Student student = dataStore.findStudentById(studentId);
        if (student == null || newName == null || newName.trim().isEmpty()) {
            return false;
        }
        student.setName(newName.trim());
        return true;
    }

    public boolean assignGradeToStudent(String studentId, String courseCode, String grade) {
        Student student = dataStore.findStudentById(studentId);
        if (student == null || !GradeUtil.isValidLetterGrade(grade)) {
            return false;
        }

        Enrollment enrollment = student.findEnrollment(courseCode);
        if (enrollment == null) {
            return false;
        }

        enrollment.markCompleted(grade.toUpperCase());
        student.dropRegisteredCourse(courseCode);
        student.addCompletedCourse(courseCode);
        student.addGrade(grade.toUpperCase());
        return true;
    }

    public List<Complaint> viewAllComplaints() {
        return complaintService.getAllComplaints();
    }

    public boolean updateComplaintStatus(String complaintId, String resolutionDetails) {
        return complaintService.resolveComplaint(complaintId, resolutionDetails);
    }

    public List<Complaint> filterComplaintsByStatus(String status) {
        return complaintService.filterByStatus(status);
    }

    public List<Complaint> filterComplaintsByDate(String date) {
        return complaintService.filterByDate(date);
    }
}

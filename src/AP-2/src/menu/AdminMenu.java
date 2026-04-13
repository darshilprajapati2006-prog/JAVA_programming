package menu;

import data.UniversityDataStore;
import java.util.List;

import model.Administrator;
import model.Complaint;
import model.Course;
import model.Student;
import service.AdminService;
import util.InputUtil;

public class AdminMenu {
    private final Administrator administrator;
    private final UniversityDataStore dataStore;
    private final AdminService adminService;
    private final InputUtil inputUtil;

    public AdminMenu(
            Administrator administrator,
            UniversityDataStore dataStore,
            AdminService adminService,
            InputUtil inputUtil) {
        this.administrator = administrator;
        this.dataStore = dataStore;
        this.adminService = adminService;
        this.inputUtil = inputUtil;
    }

    public void show() {
        boolean logout = false;
        while (!logout) {
            inputUtil.printHeader("Administrator Dashboard - " + administrator.getName());
            System.out.println("1. View Course Catalog");
            System.out.println("2. Add Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View Student Records");
            System.out.println("5. Update Student Records");
            System.out.println("6. Assign Professor to Course");
            System.out.println("7. View Complaints");
            System.out.println("8. Update Complaints");
            System.out.println("9. Filter Complaints");
            System.out.println("10. Logout");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleViewCourseCatalog();
                    break;
                case 2:
                    handleAddCourse();
                    break;
                case 3:
                    handleDeleteCourse();
                    break;
                case 4:
                    handleViewStudentRecords();
                    break;
                case 5:
                    showStudentRecordSubmenu();
                    break;
                case 6:
                    handleAssignProfessorToCourse();
                    break;
                case 7:
                    handleViewComplaints();
                    break;
                case 8:
                    handleUpdateComplaints();
                    break;
                case 9:
                    showComplaintFilterSubmenu();
                    break;
                case 10:
                    logout = true;
                    System.out.println("Administrator logout successful.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showStudentRecordSubmenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Update Student Records");
            System.out.println("1. Update Personal Information");
            System.out.println("2. Update Semester");
            System.out.println("3. Update Grade");
            System.out.println("4. Back");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleUpdateStudentName();
                    break;
                case 2:
                    handleUpdateStudentSemester();
                    break;
                case 3:
                    handleUpdateStudentGrade();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showComplaintFilterSubmenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Filter Complaints");
            System.out.println("1. Filter by Status");
            System.out.println("2. Filter by Date");
            System.out.println("3. Back");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleFilterComplaintsByStatus();
                    break;
                case 2:
                    handleFilterComplaintsByDate();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void handleViewCourseCatalog() {
        List<Course> courses = adminService.viewAllCourses();
        System.out.println();
        for (Course course : courses) {
            System.out.println(course.displayCourseInfo());
        }
        inputUtil.pause();
    }

    private void handleAddCourse() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        String title = inputUtil.readLine("Enter course title: ");
        String professor = inputUtil.readLine("Enter assigned professor name: ");
        int credits = inputUtil.readInt("Enter credits: ");
        String location = inputUtil.readLine("Enter location: ");
        String syllabus = inputUtil.readLine("Enter syllabus summary: ");
        int limit = inputUtil.readInt("Enter enrollment limit: ");
        int semester = inputUtil.readInt("Enter semester: ");

        Course course = new Course(courseCode, title, professor, credits, location, syllabus, limit, semester);
        boolean success = adminService.addCourse(course);
        System.out.println(success ? "Course added successfully." : "Course add failed.");
        inputUtil.pause();
    }

    private void handleDeleteCourse() {
        String courseCode = inputUtil.readLine("Enter course code to delete: ");
        boolean success = adminService.deleteCourse(courseCode);
        System.out.println(success ? "Course deleted successfully." : "Course delete failed.");
        inputUtil.pause();
    }

    private void handleViewStudentRecords() {
        List<Student> students = adminService.viewAllStudentRecords();
        System.out.println();
        for (Student student : students) {
            System.out.println(student.showBasicProfile());
        }
        inputUtil.pause();
    }

    private void handleAssignProfessorToCourse() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        String professorId = inputUtil.readLine("Enter professor ID/faculty ID: ");
        boolean success = adminService.assignProfessorToCourse(courseCode, professorId);
        System.out.println(success ? "Professor assigned successfully." : "Professor assignment failed.");
        inputUtil.pause();
    }

    private void handleViewComplaints() {
        List<Complaint> complaints = adminService.viewAllComplaints();
        System.out.println();
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint.displayComplaint());
            }
        }
        inputUtil.pause();
    }

    private void handleUpdateComplaints() {
        String complaintId = inputUtil.readLine("Enter complaint ID: ");
        String resolution = inputUtil.readLine("Enter resolution details: ");
        boolean success = adminService.updateComplaintStatus(complaintId, resolution);
        System.out.println(success ? "Complaint resolved successfully." : "Complaint update failed.");
        inputUtil.pause();
    }

    private void handleUpdateStudentName() {
        String studentId = inputUtil.readLine("Enter student ID: ");
        String newName = inputUtil.readLine("Enter updated name: ");
        boolean success = adminService.updateStudentName(studentId, newName);
        System.out.println(success ? "Student name updated successfully." : "Student update failed.");
        inputUtil.pause();
    }

    private void handleUpdateStudentSemester() {
        String studentId = inputUtil.readLine("Enter student ID: ");
        int semester = inputUtil.readInt("Enter updated semester: ");
        boolean success = adminService.updateStudentSemester(studentId, semester);
        System.out.println(success ? "Student semester updated successfully." : "Semester update failed.");
        inputUtil.pause();
    }

    private void handleUpdateStudentGrade() {
        String studentId = inputUtil.readLine("Enter student ID: ");
        String courseCode = inputUtil.readLine("Enter course code: ");
        String grade = inputUtil.readLine("Enter grade: ");
        boolean success = adminService.assignGradeToStudent(studentId, courseCode, grade);
        System.out.println(success ? "Student grade updated successfully." : "Grade update failed.");
        inputUtil.pause();
    }

    private void handleFilterComplaintsByStatus() {
        String status = inputUtil.readLine("Enter status (PENDING/RESOLVED): ");
        List<Complaint> complaints = adminService.filterComplaintsByStatus(status);
        System.out.println();
        if (complaints.isEmpty()) {
            System.out.println("No complaints found for the selected status.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint.displayComplaint());
            }
        }
        inputUtil.pause();
    }

    private void handleFilterComplaintsByDate() {
        String date = inputUtil.readLine("Enter date (YYYY-MM-DD): ");
        List<Complaint> complaints = adminService.filterComplaintsByDate(date);
        System.out.println();
        if (complaints.isEmpty()) {
            System.out.println("No complaints found for the selected date.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint.displayComplaint());
            }
        }
        inputUtil.pause();
    }
}

package menu;

import data.UniversityDataStore;
import exception.CourseFullException;
import exception.DropDeadlinePassedException;
import java.util.List;

import model.Complaint;
import model.Course;
import model.Enrollment;
import model.Feedback;
import model.ScheduleSlot;
import model.Student;
import service.StudentService;
import util.InputUtil;

public class StudentMenu {
    private final Student student;
    private final UniversityDataStore dataStore;
    private final StudentService studentService;
    private final InputUtil inputUtil;

    public StudentMenu(Student student, UniversityDataStore dataStore, StudentService studentService, InputUtil inputUtil) {
        this.student = student;
        this.dataStore = dataStore;
        this.studentService = studentService;
        this.inputUtil = inputUtil;
    }

    public void show() {
        boolean logout = false;
        while (!logout) {
            inputUtil.printHeader("Student Dashboard - " + student.getName());
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. View Weekly Schedule");
            System.out.println("4. Track Academic Progress");
            System.out.println("5. Drop Course");
            System.out.println("6. Submit Complaint");
            System.out.println("7. View Complaint Status");
            System.out.println("8. Give Numeric Feedback");
            System.out.println("9. Give Text Feedback");
            System.out.println("10. Logout");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleViewAvailableCourses();
                    break;
                case 2:
                    handleRegisterForCourse();
                    break;
                case 3:
                    handleViewWeeklySchedule();
                    break;
                case 4:
                    handleTrackAcademicProgress();
                    break;
                case 5:
                    handleDropCourse();
                    break;
                case 6:
                    handleSubmitComplaint();
                    break;
                case 7:
                    handleViewComplaintStatus();
                    break;
                case 8:
                    handleSubmitNumericFeedback();
                    break;
                case 9:
                    handleSubmitTextFeedback();
                    break;
                case 10:
                    logout = true;
                    System.out.println("Student logout successful.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void handleViewAvailableCourses() {
        List<Course> courses = studentService.viewAvailableCourses(student);
        System.out.println();
        System.out.println("Current Semester: " + student.getCurrentSemester());
        System.out.println("Current Registered Credits: " + studentService.getCurrentRegisteredCredits(student) + "/20");
        for (Course course : courses) {
            System.out.println(course.displayCourseInfo());
        }
        inputUtil.pause();
    }

    private void handleRegisterForCourse() {
        try {
            String courseCode = inputUtil.readLine("Enter course code to register: ");
            String validationMessage = studentService.getRegistrationValidationMessage(student, courseCode);
            boolean success = studentService.registerForCourse(student, courseCode);
            System.out.println(success ? "Course registration successful." : validationMessage);
        } catch (CourseFullException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }

    private void handleViewWeeklySchedule() {
        List<ScheduleSlot> schedule = studentService.viewSchedule(student);
        System.out.println();
        if (schedule.isEmpty()) {
            System.out.println("No active schedule found.");
        } else {
            for (ScheduleSlot slot : schedule) {
                System.out.println(slot.toDisplayString());
            }
        }
        inputUtil.pause();
    }

    private void handleTrackAcademicProgress() {
        System.out.println();
        for (Enrollment enrollment : student.getCompletedEnrollments()) {
            System.out.println(enrollment.getCourseCode() + " | Semester: " + enrollment.getSemester()
                    + " | Grade: " + enrollment.getGrade());
        }

        int currentSemester = student.getCurrentSemester();
        int lastCompletedSemester = studentService.getLastCompletedSemester(student);

        if (lastCompletedSemester > 0) {
            System.out.println("SGPA (last completed semester - Semester " + lastCompletedSemester + "): "
                    + studentService.viewSGPA(student, lastCompletedSemester));
        }

        if (studentService.isSemesterComplete(student, currentSemester)) {
            System.out.println("SGPA (current semester - Semester " + currentSemester + "): "
                    + studentService.viewSGPA(student, currentSemester));
        } else {
            System.out.println("SGPA (current semester - Semester " + currentSemester
                    + "): Not available yet because the semester is still ongoing.");
            System.out.println("Pending grade/course completion for:");
            for (String courseCode : studentService.getIncompleteSemesterCourses(student, currentSemester)) {
                System.out.println("- " + courseCode);
            }
        }

        System.out.println("CGPA: " + studentService.viewCGPA(student));
        inputUtil.pause();
    }

    private void handleDropCourse() {
        try {
            String courseCode = inputUtil.readLine("Enter course code to drop: ");
            boolean success = studentService.dropCourse(student, courseCode);
            System.out.println(success ? "Course dropped successfully." : "Course drop failed.");
        } catch (DropDeadlinePassedException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }

    private void handleSubmitComplaint() {
        String title = inputUtil.readLine("Enter complaint title: ");
        String description = inputUtil.readLine("Enter complaint description: ");
        Complaint complaint = studentService.submitComplaint(student, title, description);
        System.out.println("Complaint submitted successfully with ID: " + complaint.getComplaintId());
        inputUtil.pause();
    }

    private void handleViewComplaintStatus() {
        List<Complaint> complaints = studentService.viewComplaintStatus(student);
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

    private void handleSubmitNumericFeedback() {
        try {
            String courseCode = inputUtil.readLine("Enter completed course code: ");
            int rating = inputUtil.readInt("Enter rating between 1 and 5: ");
            Feedback<Integer> feedback = studentService.submitNumericFeedback(student, courseCode, rating);
            System.out.println("Numeric feedback submitted successfully with ID: " + feedback.getFeedbackId());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }

    private void handleSubmitTextFeedback() {
        try {
            String courseCode = inputUtil.readLine("Enter completed course code: ");
            String comment = inputUtil.readLine("Enter your feedback comment: ");
            Feedback<String> feedback = studentService.submitTextFeedback(student, courseCode, comment);
            System.out.println("Text feedback submitted successfully with ID: " + feedback.getFeedbackId());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }
}

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
import model.TeachingAssistant;
import service.StudentService;
import service.TAService;
import util.InputUtil;

public class TAMenu {
    private final TeachingAssistant teachingAssistant;
    private final UniversityDataStore dataStore;
    private final StudentService studentService;
    private final TAService taService;
    private final InputUtil inputUtil;

    public TAMenu(
            TeachingAssistant teachingAssistant,
            UniversityDataStore dataStore,
            StudentService studentService,
            TAService taService,
            InputUtil inputUtil) {
        this.teachingAssistant = teachingAssistant;
        this.dataStore = dataStore;
        this.studentService = studentService;
        this.taService = taService;
        this.inputUtil = inputUtil;
    }

    public void show() {
        boolean logout = false;
        while (!logout) {
            inputUtil.printHeader("TA Dashboard - " + teachingAssistant.getName());
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. View Weekly Schedule");
            System.out.println("4. Track Academic Progress");
            System.out.println("5. Drop Course");
            System.out.println("6. Submit Complaint");
            System.out.println("7. View Complaint Status");
            System.out.println("8. Give Numeric Feedback");
            System.out.println("9. Give Text Feedback");
            System.out.println("10. View Assigned TA Courses");
            System.out.println("11. View Students For Grade Management");
            System.out.println("12. Manage Student Grades");
            System.out.println("13. Logout");

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
                    handleViewAssignedCourses();
                    break;
                case 11:
                    handleViewStudentsForGradeManagement();
                    break;
                case 12:
                    handleManageStudentGrades();
                    break;
                case 13:
                    logout = true;
                    System.out.println("TA logout successful.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void handleViewAvailableCourses() {
        List<Course> courses = studentService.viewAvailableCourses(teachingAssistant);
        System.out.println();
        System.out.println("Current Semester: " + teachingAssistant.getCurrentSemester());
        System.out.println("Current Registered Credits: "
                + studentService.getCurrentRegisteredCredits(teachingAssistant) + "/20");
        for (Course course : courses) {
            System.out.println(course.displayCourseInfo());
        }
        inputUtil.pause();
    }

    private void handleRegisterForCourse() {
        try {
            String courseCode = inputUtil.readLine("Enter course code to register: ");
            String validationMessage = studentService.getRegistrationValidationMessage(teachingAssistant, courseCode);
            boolean success = studentService.registerForCourse(teachingAssistant, courseCode);
            System.out.println(success ? "Course registration successful." : validationMessage);
        } catch (CourseFullException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }

    private void handleViewWeeklySchedule() {
        List<ScheduleSlot> schedule = studentService.viewSchedule(teachingAssistant);
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
        for (Enrollment enrollment : teachingAssistant.getCompletedEnrollments()) {
            System.out.println(enrollment.getCourseCode() + " | Semester: " + enrollment.getSemester()
                    + " | Grade: " + enrollment.getGrade());
        }

        int currentSemester = teachingAssistant.getCurrentSemester();
        int lastCompletedSemester = studentService.getLastCompletedSemester(teachingAssistant);

        if (lastCompletedSemester > 0) {
            System.out.println("SGPA (last completed semester - Semester " + lastCompletedSemester + "): "
                    + studentService.viewSGPA(teachingAssistant, lastCompletedSemester));
        }

        if (studentService.isSemesterComplete(teachingAssistant, currentSemester)) {
            System.out.println("SGPA (current semester - Semester " + currentSemester + "): "
                    + studentService.viewSGPA(teachingAssistant, currentSemester));
        } else {
            System.out.println("SGPA (current semester - Semester " + currentSemester
                    + "): Not available yet because the semester is still ongoing.");
            System.out.println("Pending grade/course completion for:");
            for (String courseCode : studentService.getIncompleteSemesterCourses(teachingAssistant, currentSemester)) {
                System.out.println("- " + courseCode);
            }
        }

        System.out.println("CGPA: " + studentService.viewCGPA(teachingAssistant));
        inputUtil.pause();
    }

    private void handleDropCourse() {
        try {
            String courseCode = inputUtil.readLine("Enter course code to drop: ");
            boolean success = studentService.dropCourse(teachingAssistant, courseCode);
            System.out.println(success ? "Course dropped successfully." : "Course drop failed.");
        } catch (DropDeadlinePassedException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }

    private void handleSubmitComplaint() {
        String title = inputUtil.readLine("Enter complaint title: ");
        String description = inputUtil.readLine("Enter complaint description: ");
        Complaint complaint = studentService.submitComplaint(teachingAssistant, title, description);
        System.out.println("Complaint submitted successfully with ID: " + complaint.getComplaintId());
        inputUtil.pause();
    }

    private void handleViewComplaintStatus() {
        List<Complaint> complaints = studentService.viewComplaintStatus(teachingAssistant);
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
            Feedback<Integer> feedback = studentService.submitNumericFeedback(teachingAssistant, courseCode, rating);
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
            Feedback<String> feedback = studentService.submitTextFeedback(teachingAssistant, courseCode, comment);
            System.out.println("Text feedback submitted successfully with ID: " + feedback.getFeedbackId());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        inputUtil.pause();
    }

    private void handleViewAssignedCourses() {
        List<Course> courses = taService.viewAssignedCourses(teachingAssistant);
        System.out.println();
        if (courses.isEmpty()) {
            System.out.println("No TA course assignments found.");
        } else {
            for (Course course : courses) {
                System.out.println(course.displayCourseInfo());
            }
        }
        inputUtil.pause();
    }

    private void handleViewStudentsForGradeManagement() {
        String courseCode = inputUtil.readLine("Enter assigned course code: ");
        List<Student> students = taService.viewStudentsForGradeManagement(teachingAssistant, courseCode);
        System.out.println();
        if (students.isEmpty()) {
            System.out.println("No students found for this course or TA access denied.");
        } else {
            for (Student student : students) {
                Enrollment enrollment = student.findEnrollment(courseCode);
                String grade = enrollment == null || enrollment.getGrade().isEmpty() ? "Not Assigned" : enrollment.getGrade();
                System.out.println(student.showBasicProfile() + " | Grade: " + grade);
            }
        }
        inputUtil.pause();
    }

    private void handleManageStudentGrades() {
        String courseCode = inputUtil.readLine("Enter assigned course code: ");
        String studentId = inputUtil.readLine("Enter student ID: ");
        String grade = inputUtil.readLine("Enter grade (AA/AB/BB/BC/CC/CD/DD/FF): ");
        boolean success = taService.assignGrade(teachingAssistant, studentId, courseCode, grade);
        System.out.println(success ? "Grade managed successfully by TA." : "TA grade management failed.");
        inputUtil.pause();
    }
}

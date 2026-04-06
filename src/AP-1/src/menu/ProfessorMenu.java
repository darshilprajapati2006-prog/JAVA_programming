package menu;

import data.UniversityDataStore;
import java.util.List;

import model.Course;
import model.Professor;
import model.Student;
import service.ProfessorService;
import util.InputUtil;

public class ProfessorMenu {
    private final Professor professor;
    private final UniversityDataStore dataStore;
    private final ProfessorService professorService;
    private final InputUtil inputUtil;

    public ProfessorMenu(
            Professor professor,
            UniversityDataStore dataStore,
            ProfessorService professorService,
            InputUtil inputUtil) {
        this.professor = professor;
        this.dataStore = dataStore;
        this.professorService = professorService;
        this.inputUtil = inputUtil;
    }

    public void show() {
        boolean logout = false;
        while (!logout) {
            inputUtil.printHeader("Professor Dashboard - " + professor.getName());
            System.out.println("1. View Assigned Courses");
            System.out.println("2. Update Course Details");
            System.out.println("3. View Enrolled Students");
            System.out.println("4. Assign Grades");
            System.out.println("5. Update Office Hours");
            System.out.println("6. Logout");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleViewAssignedCourses();
                    break;
                case 2:
                    showCourseUpdateSubmenu();
                    break;
                case 3:
                    handleViewEnrolledStudents();
                    break;
                case 4:
                    handleAssignGrades();
                    break;
                case 5:
                    handleUpdateOfficeHours();
                    break;
                case 6:
                    logout = true;
                    System.out.println("Professor logout successful.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showCourseUpdateSubmenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Update Course Details");
            System.out.println("1. Update Syllabus");
            System.out.println("2. Update Timings");
            System.out.println("3. Update Credits");
            System.out.println("4. Update Prerequisites");
            System.out.println("5. Update Enrollment Limit");
            System.out.println("6. Back");

            int choice = inputUtil.readInt("Choose a field to update: ");
            switch (choice) {
                case 1:
                    handleUpdateSyllabus();
                    break;
                case 2:
                    handleUpdateTimings();
                    break;
                case 3:
                    handleUpdateCredits();
                    break;
                case 4:
                    handleUpdatePrerequisites();
                    break;
                case 5:
                    handleUpdateEnrollmentLimit();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void handleViewAssignedCourses() {
        List<Course> courses = professorService.viewAssignedCourses(professor);
        System.out.println();
        if (courses.isEmpty()) {
            System.out.println("No courses assigned.");
        } else {
            for (Course course : courses) {
                System.out.println(course.displayCourseInfo());
            }
        }
        inputUtil.pause();
    }

    private void handleViewEnrolledStudents() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        List<Student> students = professorService.viewEnrolledStudents(professor, courseCode);
        System.out.println();
        if (students.isEmpty()) {
            System.out.println("No enrolled students found or access denied.");
        } else {
            for (Student student : students) {
                System.out.println(student.showBasicProfile());
            }
        }
        inputUtil.pause();
    }

    private void handleAssignGrades() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        String studentId = inputUtil.readLine("Enter student ID: ");
        String grade = inputUtil.readLine("Enter grade (AA/AB/BB/BC/CC/CD/DD/FF): ");
        boolean success = professorService.assignGrade(professor, studentId, courseCode, grade);
        System.out.println(success ? "Grade assigned successfully." : "Grade assignment failed.");
        inputUtil.pause();
    }

    private void handleUpdateSyllabus() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        String syllabus = inputUtil.readLine("Enter updated syllabus: ");
        boolean success = professorService.updateCourseSyllabus(professor, courseCode, syllabus);
        System.out.println(success ? "Syllabus updated successfully." : "Syllabus update failed.");
        inputUtil.pause();
    }

    private void handleUpdateTimings() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        String day = inputUtil.readLine("Enter day: ");
        String startTime = inputUtil.readLine("Enter start time: ");
        String endTime = inputUtil.readLine("Enter end time: ");
        String room = inputUtil.readLine("Enter room: ");
        String slotLabel = inputUtil.readLine("Enter slot label: ");
        boolean success = professorService.updateCourseTimings(professor, courseCode, day, startTime, endTime, room,
                slotLabel);
        System.out.println(success ? "Course timings updated successfully." : "Timing update failed.");
        inputUtil.pause();
    }

    private void handleUpdateCredits() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        int credits = inputUtil.readInt("Enter updated credits: ");
        boolean success = professorService.updateCourseCredits(professor, courseCode, credits);
        System.out.println(success ? "Course credits updated successfully." : "Credit update failed.");
        inputUtil.pause();
    }

    private void handleUpdatePrerequisites() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        String prerequisites = inputUtil.readLine("Enter prerequisites as comma-separated course codes: ");
        boolean success = professorService.updateCoursePrerequisites(professor, courseCode, prerequisites);
        System.out.println(success ? "Course prerequisites updated successfully." : "Prerequisite update failed.");
        inputUtil.pause();
    }

    private void handleUpdateEnrollmentLimit() {
        String courseCode = inputUtil.readLine("Enter course code: ");
        int limit = inputUtil.readInt("Enter updated enrollment limit: ");
        boolean success = professorService.updateCourseEnrollmentLimit(professor, courseCode, limit);
        System.out.println(success ? "Enrollment limit updated successfully." : "Enrollment limit update failed.");
        inputUtil.pause();
    }

    private void handleUpdateOfficeHours() {
        String officeHours = inputUtil.readLine("Enter updated office hours: ");
        boolean success = professorService.updateProfessorOfficeHours(professor, officeHours);
        System.out.println(success ? "Office hours updated successfully." : "Office hours update failed.");
        inputUtil.pause();
    }
}

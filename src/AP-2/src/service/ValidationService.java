package service;

import model.Course;
import model.Enrollment;
import model.Student;

public class ValidationService {
    private static final int MAX_ALLOWED_CREDITS = 20;
    private static final int MIN_VALID_SEMESTER = 1;
    private static final int MAX_VALID_SEMESTER = 10;

    private final CourseService courseService;

    public ValidationService(CourseService courseService) {
        this.courseService = courseService;
    }

    public boolean canRegister(Student student, Course course) {
        return validateRegistration(student, course) == null;
    }

    public String validateRegistration(Student student, Course course) {
        if (student == null) {
            return "Student record not found.";
        }

        if (!isValidStudentSemester(student)) {
            return "Student current semester is invalid.";
        }

        if (course == null) {
            return "Selected course does not exist.";
        }

        if (course.getSemester() != student.getCurrentSemester()) {
            return "You can register only for courses offered in your current semester.";
        }

        if (hasAlreadyCompletedCourse(student, course.getCourseCode())) {
            return "You have already completed this course.";
        }

        if (isAlreadyRegistered(student, course.getCourseCode())) {
            return "You are already registered in this course.";
        }

        if (!hasCompletedPrerequisites(student, course)) {
            return "Prerequisite courses are not completed.";
        }

        if (isCreditLimitExceeded(student, course)) {
            return "Registration failed because the 20-credit limit would be exceeded.";
        }

        if (course.isFull()) {
            return "Registration failed because the course enrollment limit has been reached.";
        }

        return null;
    }

    public boolean isValidStudentSemester(Student student) {
        return student.getCurrentSemester() >= MIN_VALID_SEMESTER
                && student.getCurrentSemester() <= MAX_VALID_SEMESTER;
    }

    public boolean hasCompletedPrerequisites(Student student, Course course) {
        for (String prerequisite : course.getPrerequisites()) {
            if (!student.getCompletedCourses().contains(prerequisite)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCreditLimitExceeded(Student student, Course course) {
        int currentCredits = 0;
        for (Enrollment enrollment : student.getActiveEnrollments()) {
            Course enrolledCourse = courseService.findCourseByCode(enrollment.getCourseCode());
            if (enrolledCourse != null) {
                currentCredits += enrolledCourse.getCredits();
            }
        }
        return currentCredits + course.getCredits() > MAX_ALLOWED_CREDITS;
    }

    public boolean isAlreadyRegistered(Student student, String courseCode) {
        for (Enrollment enrollment : student.getActiveEnrollments()) {
            if (enrollment.getCourseCode().equalsIgnoreCase(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAlreadyCompletedCourse(Student student, String courseCode) {
        for (Enrollment enrollment : student.getCompletedEnrollments()) {
            if (enrollment.getCourseCode().equalsIgnoreCase(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean canDrop(Student student, String courseCode) {
        Enrollment enrollment = student.findEnrollment(courseCode);
        return enrollment != null && enrollment.isActive();
    }

    public int getCurrentRegisteredCredits(Student student) {
        int currentCredits = 0;
        for (Enrollment enrollment : student.getActiveEnrollments()) {
            Course enrolledCourse = courseService.findCourseByCode(enrollment.getCourseCode());
            if (enrolledCourse != null) {
                currentCredits += enrolledCourse.getCredits();
            }
        }
        return currentCredits;
    }
}

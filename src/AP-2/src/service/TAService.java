package service;

import java.util.ArrayList;
import java.util.List;

import data.UniversityDataStore;
import model.Course;
import model.Enrollment;
import model.Student;
import model.TeachingAssistant;
import util.GradeUtil;

public class TAService {
    private final UniversityDataStore dataStore;
    private final CourseService courseService;

    public TAService(UniversityDataStore dataStore, CourseService courseService) {
        this.dataStore = dataStore;
        this.courseService = courseService;
    }

    public List<Course> viewAssignedCourses(TeachingAssistant teachingAssistant) {
        List<Course> assignedCourses = new ArrayList<>();
        if (teachingAssistant == null) {
            return assignedCourses;
        }

        for (String courseCode : teachingAssistant.getAssistingCourseCodes()) {
            Course course = courseService.findCourseByCode(courseCode);
            if (course != null) {
                assignedCourses.add(course);
            }
        }
        return assignedCourses;
    }

    public List<Student> viewStudentsForGradeManagement(TeachingAssistant teachingAssistant, String courseCode) {
        List<Student> enrolledStudents = new ArrayList<>();
        Course course = getAuthorizedCourse(teachingAssistant, courseCode);
        if (course == null) {
            return enrolledStudents;
        }

        for (String studentId : course.getEnrolledStudents()) {
            Student student = dataStore.findStudentById(studentId);
            if (student != null && !(student instanceof TeachingAssistant)) {
                enrolledStudents.add(student);
            }
        }
        return enrolledStudents;
    }

    public boolean assignGrade(TeachingAssistant teachingAssistant, String studentId, String courseCode, String grade) {
        if (!GradeUtil.isValidLetterGrade(grade)) {
            return false;
        }

        Course course = getAuthorizedCourse(teachingAssistant, courseCode);
        Student student = dataStore.findStudentById(studentId);
        if (course == null || student == null || !course.getEnrolledStudents().contains(studentId)) {
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

    private Course getAuthorizedCourse(TeachingAssistant teachingAssistant, String courseCode) {
        if (teachingAssistant == null || courseCode == null || !teachingAssistant.canManageGradesFor(courseCode)) {
            return null;
        }
        return courseService.findCourseByCode(courseCode);
    }
}

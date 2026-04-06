package service;

import java.util.ArrayList;
import java.util.List;

import data.UniversityDataStore;
import model.Course;
import model.Enrollment;
import model.Professor;
import model.Student;
import util.GradeUtil;

public class ProfessorService {
    private final UniversityDataStore dataStore;
    private final CourseService courseService;

    public ProfessorService(UniversityDataStore dataStore, CourseService courseService) {
        this.dataStore = dataStore;
        this.courseService = courseService;
    }

    public List<Course> viewAssignedCourses(Professor professor) {
        return dataStore.findCoursesByProfessor(professor.getName());
    }

    public boolean updateCourseSyllabus(Professor professor, String courseCode, String syllabus) {
        Course course = getAuthorizedCourse(professor, courseCode);
        if (course == null) {
            return false;
        }
        course.setSyllabus(syllabus);
        return true;
    }

    public boolean updateCourseCredits(Professor professor, String courseCode, int credits) {
        Course course = getAuthorizedCourse(professor, courseCode);
        if (course == null) {
            return false;
        }
        course.setCredits(credits);
        return true;
    }

    public boolean updateCourseLocation(Professor professor, String courseCode, String location) {
        Course course = getAuthorizedCourse(professor, courseCode);
        if (course == null) {
            return false;
        }
        course.setLocation(location);
        return true;
    }

    public boolean updateCourseTimings(Professor professor, String courseCode, String day, String startTime,
            String endTime, String room, String slotLabel) {
        Course course = getAuthorizedCourse(professor, courseCode);
        if (course == null) {
            return false;
        }
        course.getTimings().clear();
        course.addTiming(new model.ScheduleSlot(day, startTime, endTime, room, slotLabel));
        return true;
    }

    public boolean updateCourseEnrollmentLimit(Professor professor, String courseCode, int limit) {
        Course course = getAuthorizedCourse(professor, courseCode);
        if (course == null) {
            return false;
        }
        course.setEnrollmentLimit(limit);
        return true;
    }

    public boolean updateCoursePrerequisites(Professor professor, String courseCode, String prerequisitesCsv) {
        Course course = getAuthorizedCourse(professor, courseCode);
        if (course == null) {
            return false;
        }
        course.getPrerequisites().clear();
        if (prerequisitesCsv != null && !prerequisitesCsv.trim().isEmpty()) {
            String[] prerequisites = prerequisitesCsv.split(",");
            for (String prerequisite : prerequisites) {
                String normalized = prerequisite.trim();
                if (!normalized.isEmpty()) {
                    course.addPrerequisite(normalized);
                }
            }
        }
        return true;
    }

    public boolean updateProfessorOfficeHours(Professor professor, String officeHours) {
        if (professor == null || officeHours == null || officeHours.trim().isEmpty()) {
            return false;
        }
        Professor actualProfessor = dataStore.findProfessorById(professor.getId());
        if (actualProfessor == null) {
            return false;
        }
        actualProfessor.setOfficeHours(officeHours.trim());
        professor.setOfficeHours(officeHours.trim());
        return true;
    }

    public List<Student> viewEnrolledStudents(Professor professor, String courseCode) {
        Course course = getAuthorizedCourse(professor, courseCode);
        List<Student> enrolledStudents = new ArrayList<>();
        if (course == null) {
            return enrolledStudents;
        }

        for (String studentId : course.getEnrolledStudents()) {
            Student student = dataStore.findStudentById(studentId);
            if (student != null) {
                enrolledStudents.add(student);
            }
        }
        return enrolledStudents;
    }

    public boolean assignGrade(Professor professor, String studentId, String courseCode, String grade) {
        if (!GradeUtil.isValidLetterGrade(grade)) {
            return false;
        }

        Course course = getAuthorizedCourse(professor, courseCode);
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

    private Course getAuthorizedCourse(Professor professor, String courseCode) {
        Course course = courseService.findCourseByCode(courseCode);
        if (course == null) {
            return null;
        }
        if (!course.getProfessor().equalsIgnoreCase(professor.getName())) {
            return null;
        }
        return course;
    }
}

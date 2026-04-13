package service;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Enrollment;
import model.Student;
import util.GradeUtil;

public class GPAService {
    private final CourseService courseService;

    public GPAService(CourseService courseService) {
        this.courseService = courseService;
    }

    public double calculateSGPA(Student student, int semester) {
        Double reportedSgpa = student.getReportedSgpa(semester);
        if (reportedSgpa != null) {
            return reportedSgpa;
        }

        if (!isSemesterComplete(student, semester)) {
            return -1.0;
        }

        double totalWeightedPoints = 0.0;
        int totalCredits = 0;

        for (Enrollment enrollment : student.getCompletedEnrollments()) {
            if (enrollment.getSemester() == semester && GradeUtil.isValidLetterGrade(enrollment.getGrade())) {
                Course course = courseService.findCourseByCode(enrollment.getCourseCode());
                if (course != null) {
                    totalWeightedPoints += course.getCredits() * GradeUtil.getGradePoint(enrollment.getGrade());
                    totalCredits += course.getCredits();
                }
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        }
        return Math.round((totalWeightedPoints / totalCredits) * 100.0) / 100.0;
    }

    public double calculateCGPA(Student student) {
        if (student.getReportedCgpa() != null) {
            return student.getReportedCgpa();
        }

        double totalWeightedPoints = 0.0;
        int totalCredits = 0;

        for (Enrollment enrollment : student.getCompletedEnrollments()) {
            if (GradeUtil.isPassingGrade(enrollment.getGrade())) {
                Course course = courseService.findCourseByCode(enrollment.getCourseCode());
                if (course != null) {
                    totalWeightedPoints += course.getCredits() * GradeUtil.getGradePoint(enrollment.getGrade());
                    totalCredits += course.getCredits();
                }
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        }
        return Math.round((totalWeightedPoints / totalCredits) * 100.0) / 100.0;
    }

    public boolean isSemesterComplete(Student student, int semester) {
        boolean hasSemesterRecord = false;

        for (Enrollment enrollment : student.getEnrollments()) {
            if (enrollment.getSemester() == semester) {
                hasSemesterRecord = true;
                if (!enrollment.isCompleted() || !GradeUtil.isValidLetterGrade(enrollment.getGrade())) {
                    return false;
                }
            }
        }

        return hasSemesterRecord;
    }

    public List<String> getIncompleteSemesterCourses(Student student, int semester) {
        List<String> pendingCourses = new ArrayList<>();

        for (Enrollment enrollment : student.getEnrollments()) {
            if (enrollment.getSemester() == semester
                    && (!enrollment.isCompleted() || !GradeUtil.isValidLetterGrade(enrollment.getGrade()))) {
                pendingCourses.add(enrollment.getCourseCode());
            }
        }

        return pendingCourses;
    }
}

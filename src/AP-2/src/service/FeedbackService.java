package service;

import data.UniversityDataStore;
import java.time.LocalDate;
import java.util.List;
import model.Course;
import model.Feedback;
import model.Student;

public class FeedbackService {
    private static final String NUMERIC_FEEDBACK = "Numeric Rating";
    private static final String TEXT_FEEDBACK = "Text Comment";

    private final UniversityDataStore dataStore;
    private final CourseService courseService;

    public FeedbackService(UniversityDataStore dataStore, CourseService courseService) {
        this.dataStore = dataStore;
        this.courseService = courseService;
    }

    public Feedback<Integer> submitNumericFeedback(Student student, String courseCode, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Numeric rating must be between 1 and 5.");
        }
        Course course = validateFeedbackEligibility(student, courseCode);
        ensureFeedbackTypeNotAlreadySubmitted(student, courseCode, NUMERIC_FEEDBACK);
        return submitFeedback(student, course, rating, NUMERIC_FEEDBACK);
    }

    public Feedback<String> submitTextFeedback(Student student, String courseCode, String comment) {
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("Text feedback cannot be empty.");
        }
        Course course = validateFeedbackEligibility(student, courseCode);
        ensureFeedbackTypeNotAlreadySubmitted(student, courseCode, TEXT_FEEDBACK);
        return submitFeedback(student, course, comment.trim(), TEXT_FEEDBACK);
    }

    public List<Feedback<?>> viewCourseFeedback(String courseCode) {
        return dataStore.findFeedbackByCourseCode(courseCode);
    }

    private Course validateFeedbackEligibility(Student student, String courseCode) {
        if (student == null) {
            throw new IllegalArgumentException("Student record not found.");
        }
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }

        Course course = courseService.findCourseByCode(courseCode.trim());
        if (course == null) {
            throw new IllegalArgumentException("Selected course does not exist.");
        }
        if (!student.getCompletedCourses().contains(course.getCourseCode())) {
            throw new IllegalArgumentException("Feedback can only be submitted for completed courses.");
        }
        return course;
    }

    private void ensureFeedbackTypeNotAlreadySubmitted(Student student, String courseCode, String feedbackType) {
        Feedback<?> existingFeedback = dataStore.findFeedbackByStudentCourseAndType(
                student.getId(),
                courseCode,
                feedbackType);
        if (existingFeedback != null) {
            throw new IllegalArgumentException(
                    "You have already submitted " + feedbackType.toLowerCase() + " for this course.");
        }
    }

    private <T> Feedback<T> submitFeedback(Student student, Course course, T value, String feedbackType) {
        Feedback<T> feedback = new Feedback<>(
                generateFeedbackId(),
                student.getId(),
                student.getName(),
                course.getCourseCode(),
                course.getTitle(),
                feedbackType,
                value,
                LocalDate.now());
        dataStore.addFeedback(feedback);
        return feedback;
    }

    private String generateFeedbackId() {
        return String.format("FDB%03d", dataStore.getFeedbacks().size() + 1);
    }
}

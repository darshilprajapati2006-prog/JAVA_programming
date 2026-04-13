package model;

import java.time.LocalDate;

public class Feedback<T> {
    private final String feedbackId;
    private final String studentId;
    private final String studentName;
    private final String courseCode;
    private final String courseTitle;
    private final String feedbackType;
    private final T value;
    private final LocalDate submittedOn;

    public Feedback(
            String feedbackId,
            String studentId,
            String studentName,
            String courseCode,
            String courseTitle,
            String feedbackType,
            T value,
            LocalDate submittedOn) {
        this.feedbackId = feedbackId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.feedbackType = feedbackType;
        this.value = value;
        this.submittedOn = submittedOn;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public T getValue() {
        return value;
    }

    public LocalDate getSubmittedOn() {
        return submittedOn;
    }

    public String displayFeedback() {
        return feedbackId
                + " | Course: " + courseCode + " - " + courseTitle
                + " | Student: " + studentName
                + " | Type: " + feedbackType
                + " | Value: " + value
                + " | Submitted On: " + submittedOn;
    }
}

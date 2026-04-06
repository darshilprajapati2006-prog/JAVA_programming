package service;

import java.util.ArrayList;
import java.util.List;

import data.UniversityDataStore;
import model.Complaint;
import model.Course;
import model.Enrollment;
import model.ScheduleSlot;
import model.Student;

public class StudentService {
    private final UniversityDataStore dataStore;
    private final CourseService courseService;
    private final ComplaintService complaintService;
    private final GPAService gpaService;
    private final ValidationService validationService;

    public StudentService(
            UniversityDataStore dataStore,
            CourseService courseService,
            ComplaintService complaintService,
            GPAService gpaService,
            ValidationService validationService) {
        this.dataStore = dataStore;
        this.courseService = courseService;
        this.complaintService = complaintService;
        this.gpaService = gpaService;
        this.validationService = validationService;
    }

    public List<Course> viewAvailableCourses(Student student) {
        return courseService.listCoursesBySemester(student.getCurrentSemester());
    }

    public boolean registerForCourse(Student student, String courseCode) {
        Course course = courseService.findCourseByCode(courseCode);
        if (!validationService.canRegister(student, course)) {
            return false;
        }

        if (!course.addStudent(student.getId())) {
            return false;
        }

        student.addRegisteredCourse(courseCode);
        student.addEnrollment(new Enrollment(student.getId(), courseCode, student.getCurrentSemester()));
        return true;
    }

    public String getRegistrationValidationMessage(Student student, String courseCode) {
        Course course = courseService.findCourseByCode(courseCode);
        String validationMessage = validationService.validateRegistration(student, course);
        return validationMessage == null ? "Course registration successful." : validationMessage;
    }

    public int getCurrentRegisteredCredits(Student student) {
        return validationService.getCurrentRegisteredCredits(student);
    }

    public boolean dropCourse(Student student, String courseCode) {
        if (!validationService.canDrop(student, courseCode)) {
            return false;
        }

        Course course = courseService.findCourseByCode(courseCode);
        Enrollment enrollment = student.findEnrollment(courseCode);
        if (course == null || enrollment == null) {
            return false;
        }

        course.removeStudent(student.getId());
        student.dropRegisteredCourse(courseCode);
        enrollment.markDropped();
        return true;
    }

    public List<ScheduleSlot> viewSchedule(Student student) {
        List<ScheduleSlot> schedule = new ArrayList<>();
        for (Enrollment enrollment : student.getActiveEnrollments()) {
            Course course = courseService.findCourseByCode(enrollment.getCourseCode());
            if (course != null) {
                schedule.addAll(course.getTimings());
            }
        }
        return schedule;
    }

    public double viewSGPA(Student student, int semester) {
        return gpaService.calculateSGPA(student, semester);
    }

    public double viewCGPA(Student student) {
        return gpaService.calculateCGPA(student);
    }

    public boolean isSemesterComplete(Student student, int semester) {
        return gpaService.isSemesterComplete(student, semester);
    }

    public List<String> getIncompleteSemesterCourses(Student student, int semester) {
        return gpaService.getIncompleteSemesterCourses(student, semester);
    }

    public Complaint submitComplaint(Student student, String title, String description) {
        Complaint complaint = complaintService.createComplaint(student, title, description);
        student.addComplaint(complaint);
        return complaint;
    }

    public List<Complaint> viewComplaintStatus(Student student) {
        return dataStore.findComplaintsByStudentId(student.getId());
    }
}

package service;

import java.util.List;

import data.UniversityDataStore;
import model.Course;
import model.Professor;

public class CourseService {
    private final UniversityDataStore dataStore;

    public CourseService(UniversityDataStore dataStore) {
        this.dataStore = dataStore;
    }

    public List<Course> listAllCourses() {
        return dataStore.getCourses();
    }

    public List<Course> listCoursesBySemester(int semester) {
        return dataStore.findCoursesBySemester(semester);
    }

    public Course findCourseByCode(String courseCode) {
        return dataStore.findCourseByCode(courseCode);
    }

    public boolean addCourse(Course course) {
        if (course == null || dataStore.containsCourseCode(course.getCourseCode())) {
            return false;
        }
        dataStore.addCourse(course);
        return true;
    }

    public boolean deleteCourse(String courseCode) {
        Course course = dataStore.findCourseByCode(courseCode);
        if (course == null) {
            return false;
        }
        return dataStore.removeCourse(course);
    }

    public boolean assignProfessor(String courseCode, Professor professor) {
        Course course = dataStore.findCourseByCode(courseCode);
        if (course == null || professor == null) {
            return false;
        }
        course.setProfessor(professor.getName());
        professor.assignCourse(courseCode);
        return true;
    }
}

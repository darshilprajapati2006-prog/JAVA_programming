package data;

import java.util.ArrayList;
import java.util.List;

import model.Administrator;
import model.Complaint;
import model.Course;
import model.Professor;
import model.Student;

public class DataStore {
    private final List<Student> students;
    private final List<Professor> professors;
    private final List<Administrator> administrators;
    private final List<Course> courses;
    private final List<Complaint> complaints;

    public DataStore() {
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.administrators = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.complaints = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public boolean removeProfessor(Professor professor) {
        return professors.remove(professor);
    }

    public boolean removeAdministrator(Administrator administrator) {
        return administrators.remove(administrator);
    }

    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    public boolean removeComplaint(Complaint complaint) {
        return complaints.remove(complaint);
    }

    public void clearAll() {
        students.clear();
        professors.clear();
        administrators.clear();
        courses.clear();
        complaints.clear();
    }
}

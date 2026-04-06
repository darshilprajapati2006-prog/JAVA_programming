package service;

import data.UniversityDataStore;
import model.Administrator;
import model.Professor;
import model.Student;

public class AuthService {
    private static final String DEFAULT_DEPARTMENT = "Artificial Intelligence";
    private static final String DEFAULT_PROGRAM = "Integrated B.Tech + M.Tech in Artificial Intelligence";
    private static final String DEFAULT_DIVISION = "A";

    private final UniversityDataStore dataStore;

    public AuthService(UniversityDataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Student registerStudent(
            String name,
            String email,
            String password,
            String rollNumber,
            String admissionNumber,
            int currentSemester) {
        validateRequiredField(name, "Student name");
        validateRequiredField(email, "Student email");
        validateRequiredField(password, "Student password");
        validateRequiredField(rollNumber, "Student roll number");
        validateRequiredField(admissionNumber, "Student admission number");
        validateDuplicateEmail(email);

        String studentId = generateStudentId();
        Student student = new Student(
                studentId,
                name.trim(),
                email.trim(),
                password,
                DEFAULT_DEPARTMENT,
                rollNumber.trim(),
                admissionNumber.trim(),
                DEFAULT_PROGRAM,
                DEFAULT_DIVISION,
                currentSemester);
        dataStore.addStudent(student);
        return student;
    }

    public Professor registerProfessor(
            String name,
            String email,
            String password,
            String facultyId,
            String expertise,
            String officeRoom,
            String officeHours) {
        validateRequiredField(name, "Professor name");
        validateRequiredField(email, "Professor email");
        validateRequiredField(password, "Professor password");
        validateRequiredField(facultyId, "Professor faculty ID");
        validateRequiredField(expertise, "Professor expertise");
        validateRequiredField(officeRoom, "Professor office room");
        validateRequiredField(officeHours, "Professor office hours");
        validateDuplicateEmail(email);

        String professorId = generateProfessorId();
        Professor professor = new Professor(
                professorId,
                name.trim(),
                email.trim(),
                password,
                DEFAULT_DEPARTMENT,
                facultyId.trim(),
                expertise.trim(),
                officeRoom.trim(),
                officeHours.trim());
        dataStore.addProfessor(professor);
        return professor;
    }

    public Student loginStudent(String email, String password) {
        validateRequiredField(email, "Student email");
        validateRequiredField(password, "Student password");

        Student student = dataStore.findStudentByEmail(email.trim());
        if (student == null) {
            throw new IllegalArgumentException("No student account found for the provided email.");
        }
        if (!student.checkPassword(password)) {
            throw new IllegalArgumentException("Incorrect student password.");
        }
        return student;
    }

    public Professor loginProfessor(String email, String password) {
        validateRequiredField(email, "Professor email");
        validateRequiredField(password, "Professor password");

        Professor professor = dataStore.findProfessorByEmail(email.trim());
        if (professor == null) {
            throw new IllegalArgumentException("No professor account found for the provided email.");
        }
        if (!professor.checkPassword(password)) {
            throw new IllegalArgumentException("Incorrect professor password.");
        }
        return professor;
    }

    public Administrator loginAdministrator(String identifier, String password) {
        validateRequiredField(identifier, "Administrator ID or email");
        validateRequiredField(password, "Administrator password");

        Administrator administrator = dataStore.findAdministratorById(identifier.trim());
        if (administrator == null) {
            administrator = dataStore.findAdministratorByEmail(identifier.trim());
        }
        if (administrator == null) {
            throw new IllegalArgumentException("No administrator account found for the provided credentials.");
        }
        if (!administrator.validateFixedPassword(password)) {
            throw new IllegalArgumentException("Incorrect administrator password.");
        }
        return administrator;
    }

    private void validateDuplicateEmail(String email) {
        String normalizedEmail = email.trim();
        if (dataStore.containsStudentEmail(normalizedEmail)
                || dataStore.containsProfessorEmail(normalizedEmail)
                || dataStore.containsAdministratorEmail(normalizedEmail)) {
            throw new IllegalArgumentException("Duplicate email is not allowed.");
        }
    }

    private void validateRequiredField(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
    }

    private String generateStudentId() {
        return String.format("STU%03d", dataStore.getStudents().size() + 1);
    }

    private String generateProfessorId() {
        return String.format("PROF%03d", dataStore.getProfessors().size() + 1);
    }
}

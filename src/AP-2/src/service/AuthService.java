package service;

import data.UniversityDataStore;
import exception.InvalidLoginException;
import model.Administrator;
import model.Professor;
import model.Student;
import model.TeachingAssistant;

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

    public TeachingAssistant registerTeachingAssistant(
            String name,
            String email,
            String password,
            String rollNumber,
            String admissionNumber,
            int currentSemester,
            String supervisingProfessorName) {
        validateRequiredField(name, "Teaching Assistant name");
        validateRequiredField(email, "Teaching Assistant email");
        validateRequiredField(password, "Teaching Assistant password");
        validateRequiredField(rollNumber, "Teaching Assistant roll number");
        validateRequiredField(admissionNumber, "Teaching Assistant admission number");
        validateRequiredField(supervisingProfessorName, "Supervising professor name");
        validateDuplicateEmail(email);

        String teachingAssistantId = generateTeachingAssistantId();
        String taCode = generateTeachingAssistantCode();
        TeachingAssistant teachingAssistant = new TeachingAssistant(
                teachingAssistantId,
                name.trim(),
                email.trim(),
                password,
                DEFAULT_DEPARTMENT,
                rollNumber.trim(),
                admissionNumber.trim(),
                DEFAULT_PROGRAM,
                DEFAULT_DIVISION,
                currentSemester,
                taCode,
                supervisingProfessorName.trim());
        dataStore.addTeachingAssistant(teachingAssistant);
        return teachingAssistant;
    }

    public Student loginStudent(String email, String password) throws InvalidLoginException {
        validateRequiredField(email, "Student email");
        validateRequiredField(password, "Student password");

        Student student = dataStore.findStudentByEmail(email.trim());
        if (student == null) {
            throw new InvalidLoginException("No student account found for the provided email.");
        }
        if (student instanceof TeachingAssistant) {
            throw new InvalidLoginException("This account is registered as a teaching assistant. Please use TA login.");
        }
        if (!student.checkPassword(password)) {
            throw new InvalidLoginException("Incorrect student password.");
        }
        return student;
    }

    public Professor loginProfessor(String email, String password) throws InvalidLoginException {
        validateRequiredField(email, "Professor email");
        validateRequiredField(password, "Professor password");

        Professor professor = dataStore.findProfessorByEmail(email.trim());
        if (professor == null) {
            throw new InvalidLoginException("No professor account found for the provided email.");
        }
        if (!professor.checkPassword(password)) {
            throw new InvalidLoginException("Incorrect professor password.");
        }
        return professor;
    }

    public TeachingAssistant loginTeachingAssistant(String email, String password) throws InvalidLoginException {
        validateRequiredField(email, "Teaching Assistant email");
        validateRequiredField(password, "Teaching Assistant password");

        TeachingAssistant teachingAssistant = dataStore.findTeachingAssistantByEmail(email.trim());
        if (teachingAssistant == null) {
            throw new InvalidLoginException("No teaching assistant account found for the provided email.");
        }
        if (!teachingAssistant.checkPassword(password)) {
            throw new InvalidLoginException("Incorrect teaching assistant password.");
        }
        return teachingAssistant;
    }

    public Administrator loginAdministrator(String identifier, String password) throws InvalidLoginException {
        validateRequiredField(identifier, "Administrator ID or email");
        validateRequiredField(password, "Administrator password");

        Administrator administrator = dataStore.findAdministratorById(identifier.trim());
        if (administrator == null) {
            administrator = dataStore.findAdministratorByEmail(identifier.trim());
        }
        if (administrator == null) {
            throw new InvalidLoginException("No administrator account found for the provided credentials.");
        }
        if (!administrator.validateFixedPassword(password)) {
            throw new InvalidLoginException("Incorrect administrator password.");
        }
        return administrator;
    }

    private void validateDuplicateEmail(String email) {
        String normalizedEmail = email.trim();
        if (dataStore.containsStudentEmail(normalizedEmail)
                || dataStore.containsTeachingAssistantEmail(normalizedEmail)
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

    private String generateTeachingAssistantId() {
        return String.format("TA%03d", dataStore.getTeachingAssistants().size() + 1);
    }

    private String generateTeachingAssistantCode() {
        return String.format("TAI%03d", dataStore.getTeachingAssistants().size() + 1);
    }
}

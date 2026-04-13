package menu;

import data.UniversityDataStore;
import exception.InvalidLoginException;
import model.Administrator;
import model.Professor;
import model.Student;
import model.TeachingAssistant;
import service.AdminService;
import service.AuthService;
import service.ProfessorService;
import service.StudentService;
import service.TAService;
import util.InputUtil;

public class AuthMenu {
    private final UniversityDataStore dataStore;
    private final AuthService authService;
    private final AdminService adminService;
    private final ProfessorService professorService;
    private final StudentService studentService;
    private final TAService taService;
    private final InputUtil inputUtil;

    public AuthMenu(
            UniversityDataStore dataStore,
            AuthService authService,
            AdminService adminService,
            ProfessorService professorService,
            StudentService studentService,
            TAService taService,
            InputUtil inputUtil) {
        this.dataStore = dataStore;
        this.authService = authService;
        this.adminService = adminService;
        this.professorService = professorService;
        this.studentService = studentService;
        this.taService = taService;
        this.inputUtil = inputUtil;
    }

    public void showRoleSelection() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Login As");
            System.out.println("1. Student");
            System.out.println("2. Teaching Assistant");
            System.out.println("3. Professor");
            System.out.println("4. Administrator");
            System.out.println("5. Back");

            int choice = inputUtil.readInt("Choose a role: ");
            switch (choice) {
                case 1:
                    showStudentAuthMenu();
                    break;
                case 2:
                    showTeachingAssistantAuthMenu();
                    break;
                case 3:
                    showProfessorAuthMenu();
                    break;
                case 4:
                    showAdministratorAuthMenu();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid role option.");
            }
        }
    }

    private void showTeachingAssistantAuthMenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Teaching Assistant Authentication");
            System.out.println("1. TA Login");
            System.out.println("2. TA Signup");
            System.out.println("3. Back");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleTeachingAssistantLogin();
                    break;
                case 2:
                    handleTeachingAssistantSignup();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showStudentAuthMenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Student Authentication");
            System.out.println("1. Student Login");
            System.out.println("2. Student Signup");
            System.out.println("3. Back");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleStudentLogin();
                    break;
                case 2:
                    handleStudentSignup();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showProfessorAuthMenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Professor Authentication");
            System.out.println("1. Professor Login");
            System.out.println("2. Professor Signup");
            System.out.println("3. Back");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleProfessorLogin();
                    break;
                case 2:
                    handleProfessorSignup();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showAdministratorAuthMenu() {
        boolean back = false;
        while (!back) {
            inputUtil.printHeader("Administrator Authentication");
            System.out.println("1. Administrator Login");
            System.out.println("2. Back");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    handleAdministratorLogin();
                    break;
                case 2:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void handleStudentLogin() {
        try {
            String email = inputUtil.readLine("Enter student email: ");
            String password = inputUtil.readLine("Enter student password: ");
            Student student = authService.loginStudent(email, password);
            new StudentMenu(student, dataStore, studentService, inputUtil).show();
        } catch (InvalidLoginException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }

    private void handleStudentSignup() {
        try {
            String name = inputUtil.readLine("Enter student name: ");
            String email = inputUtil.readLine("Enter student email: ");
            String password = inputUtil.readLine("Create student password: ");
            String rollNumber = inputUtil.readLine("Enter roll number: ");
            String admissionNumber = inputUtil.readLine("Enter admission number: ");
            int currentSemester = inputUtil.readInt("Enter current semester: ");
            Student student = authService.registerStudent(
                    name,
                    email,
                    password,
                    rollNumber,
                    admissionNumber,
                    currentSemester);
            System.out.println("Student signup successful for " + student.getName() + ".");
            inputUtil.pause();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }

    private void handleProfessorLogin() {
        try {
            String email = inputUtil.readLine("Enter professor email: ");
            String password = inputUtil.readLine("Enter professor password: ");
            Professor professor = authService.loginProfessor(email, password);
            new ProfessorMenu(professor, dataStore, professorService, inputUtil).show();
        } catch (InvalidLoginException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }

    private void handleTeachingAssistantLogin() {
        try {
            String email = inputUtil.readLine("Enter TA email: ");
            String password = inputUtil.readLine("Enter TA password: ");
            TeachingAssistant teachingAssistant = authService.loginTeachingAssistant(email, password);
            new TAMenu(teachingAssistant, dataStore, studentService, taService, inputUtil).show();
        } catch (InvalidLoginException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }

    private void handleTeachingAssistantSignup() {
        try {
            String name = inputUtil.readLine("Enter TA name: ");
            String email = inputUtil.readLine("Enter TA email: ");
            String password = inputUtil.readLine("Create TA password: ");
            String rollNumber = inputUtil.readLine("Enter roll number: ");
            String admissionNumber = inputUtil.readLine("Enter admission number: ");
            int currentSemester = inputUtil.readInt("Enter current semester: ");
            String supervisingProfessorName = inputUtil.readLine("Enter supervising professor name: ");
            TeachingAssistant teachingAssistant = authService.registerTeachingAssistant(
                    name,
                    email,
                    password,
                    rollNumber,
                    admissionNumber,
                    currentSemester,
                    supervisingProfessorName);
            System.out.println("TA signup successful for " + teachingAssistant.getName() + ".");
            inputUtil.pause();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }

    private void handleProfessorSignup() {
        try {
            String name = inputUtil.readLine("Enter professor name: ");
            String email = inputUtil.readLine("Enter professor email: ");
            String password = inputUtil.readLine("Create professor password: ");
            String facultyId = inputUtil.readLine("Enter faculty ID: ");
            String expertise = inputUtil.readLine("Enter expertise: ");
            String officeRoom = inputUtil.readLine("Enter office room: ");
            String officeHours = inputUtil.readLine("Enter office hours: ");
            Professor professor = authService.registerProfessor(
                    name,
                    email,
                    password,
                    facultyId,
                    expertise,
                    officeRoom,
                    officeHours);
            System.out.println("Professor signup successful for " + professor.getName() + ".");
            inputUtil.pause();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }

    private void handleAdministratorLogin() {
        try {
            String identifier = inputUtil.readLine("Enter administrator ID or email: ");
            String password = inputUtil.readLine("Enter administrator password: ");
            Administrator administrator = authService.loginAdministrator(identifier, password);
            new AdminMenu(administrator, dataStore, adminService, inputUtil).show();
        } catch (InvalidLoginException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputUtil.pause();
        }
    }
}

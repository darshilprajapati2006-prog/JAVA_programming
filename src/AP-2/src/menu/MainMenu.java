package menu;

import data.UniversityDataStore;
import service.AdminService;
import service.AuthService;
import service.ProfessorService;
import service.StudentService;
import service.TAService;
import util.InputUtil;

public class MainMenu {
    private final UniversityDataStore dataStore;
    private final AuthService authService;
    private final AdminService adminService;
    private final ProfessorService professorService;
    private final StudentService studentService;
    private final TAService taService;
    private final InputUtil inputUtil;

    public MainMenu(
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

    public void show() {
        boolean running = true;
        while (running) {
            inputUtil.printHeader("Welcome to the SVNIT Course Registration System");
            System.out.println("1. Enter Application");
            System.out.println("2. Exit Application");

            int choice = inputUtil.readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    AuthMenu authMenu = new AuthMenu(
                            dataStore,
                            authService,
                            adminService,
                            professorService,
                            studentService,
                            taService,
                            inputUtil);
                    authMenu.showRoleSelection();
                    break;
                case 2:
                    running = false;
                    System.out.println("Exiting application safely.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 or 2.");
            }
        }
    }
}

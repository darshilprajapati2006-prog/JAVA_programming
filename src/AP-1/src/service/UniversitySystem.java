package service;

import data.SeedData;
import data.UniversityDataStore;
import menu.MainMenu;
import util.InputUtil;

public class UniversitySystem {
    private final UniversityDataStore dataStore;
    private final AuthService authService;
    private final CourseService courseService;
    private final ComplaintService complaintService;
    private final GPAService gpaService;
    private final ValidationService validationService;
    private final AdminService adminService;
    private final ProfessorService professorService;
    private final StudentService studentService;
    private final InputUtil inputUtil;

    public UniversitySystem() {
        this.dataStore = new UniversityDataStore();
        SeedData.initialize(dataStore);
        this.courseService = new CourseService(dataStore);
        this.complaintService = new ComplaintService(dataStore);
        this.gpaService = new GPAService(courseService);
        this.validationService = new ValidationService(courseService);
        this.adminService = new AdminService(dataStore, courseService, complaintService);
        this.professorService = new ProfessorService(dataStore, courseService);
        this.studentService = new StudentService(dataStore, courseService, complaintService, gpaService, validationService);
        this.authService = new AuthService(dataStore);
        this.inputUtil = new InputUtil();
    }

    public void start() {
        System.out.println(SeedData.getDemoSummary());
        MainMenu mainMenu = new MainMenu(
                dataStore,
                authService,
                adminService,
                professorService,
                studentService,
                inputUtil);
        mainMenu.show();
    }
}

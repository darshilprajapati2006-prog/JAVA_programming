package OOPs_LAB7;

abstract class ProjectBase {
    String className;

    ProjectBase(String className) {
        this.className = className;
    }

    void debugStart() {
        System.out.println("Debugging started for class: " + className);
    }

    void debugInfo() {
        System.out.println("Showing debug information for class: " + className);
    }

    void debugEnd() {
        System.out.println("Debugging ended for class: " + className);
    }

    abstract void runModule();
}

class EmployeeModule extends ProjectBase {
    EmployeeModule() {
        super("EmployeeModule");
    }

    @Override
    void runModule() {
        System.out.println("Employee Module is running.");
    }
}

class StudentModule extends ProjectBase {
    StudentModule() {
        super("StudentModule");
    }

    @Override
    void runModule() {
        System.out.println("Student Module is running.");
    }
}

public class p5 {
    public static void main(String[] args) {
        EmployeeModule employee = new EmployeeModule();
        StudentModule student = new StudentModule();

        employee.debugStart();
        employee.runModule();
        employee.debugInfo();
        employee.debugEnd();

        System.out.println();

        student.debugStart();
        student.runModule();
        student.debugInfo();
        student.debugEnd();
    }
}

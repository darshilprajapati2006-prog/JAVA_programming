package OOPs_LAB7;

class Teacher {
    int id;
    String name;
    String department;

    Teacher(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void displayTeacherDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

class Student extends Teacher {
    String course;
    int semester;

    Student(int id, String name, String department, String course, int semester) {
        super(id, name, department);
        this.course = course;
        this.semester = semester;
    }

    void displayStudentDetails() {
        displayTeacherDetails();
        System.out.println("Course: " + course);
        System.out.println("Semester: " + semester);
    }
}

public class p4 {
    public static void main(String[] args) {
        Student student = new Student(101, "Rohit Sharma", "AI", "B.tech", 2);

        System.out.println("Student Details");
        student.displayStudentDetails();
    }
}

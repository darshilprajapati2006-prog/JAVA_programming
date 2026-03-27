package OOPs_LAB7;

class Course {
    int id;
    String description;
    int duration;
    double fees;

    Course(int id, String description, int duration, double fees) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.fees = fees;
    }

    void GetData() {
        System.out.println("Course ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fees: " + fees);
    }
}

public class p6 {
    public static void main(String[] args) {
        Course[] courses = new Course[5];

        courses[0] = new Course(101, "Java Programming", 6, 12000);
        courses[1] = new Course(102, "Python Programming", 4, 10000);
        courses[2] = new Course(103, "Web Development", 5, 15000);
        courses[3] = new Course(104, "Data Structures", 3, 9000);
        courses[4] = new Course(105, "Database Management", 4, 11000);

        for (int i = 0; i < courses.length; i++) {
            System.out.println("Course " + (i + 1) + " Details");
            courses[i].GetData();
            System.out.println();
        }
    }
}

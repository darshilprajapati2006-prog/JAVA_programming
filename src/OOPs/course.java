package OOPs;

public class course{
    static int maxcapacity=100;
    String coursename;
    int enrollStudents;
    course(String coursename){
        this.coursename=coursename;
        this.enrollStudents=0;
    }
    String[] enrollmentStudents = new String[maxcapacity];
    void enrollstudent(String studentname){
        enrollmentStudents[enrollStudents] = studentname;
        enrollStudents++;
    }
    void unenrollstudent(String studentname){
        System.out.println("student removed");
        enrollStudents--;
    }
    static void setMaxcapacity(int maxcapacity){
        course.maxcapacity = maxcapacity;
    }

    public static void main(String[] args) {
        course math = new course("math");
        math.enrollstudent("darshil");
        math.unenrollstudent("darshil");
    }
}

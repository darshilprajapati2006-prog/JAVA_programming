package OOPs_LAB5;
/* ->ALGO:
START
CREATE class Student
METHOD inputName()
    INPUT name
    RETURN name
METHOD average(m1, m2, m3)
    avg = (m1 + m2 + m3) / 3
    IF avg > 50
        RETURN "Pass"
    ELSE
        RETURN "Fail"
MAIN
    CREATE object s
    CALL inputName()
    STORE name
    INPUT m1, m2, m3
    CALL average(m1, m2, m3)
    STORE result
    PRINT name and result
END
 */
import java.util.Scanner;

class Student {
    String inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        return sc.nextLine();
    }

    String average(int m1, int m2, int m3) {
        int avg = (m1 + m2 + m3) / 3;
        if (avg > 50)
            return "Pass";
        else
            return "Fail";
    }
}

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s = new Student();

        String name = s.inputName();

        System.out.print("Enter marks of 3 subjects: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();

        String result = s.average(m1, m2, m3);

        System.out.println("Name: " + name);
        System.out.println("Result: " + result);
    }
}
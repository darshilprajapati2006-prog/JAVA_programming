package basicsOFjava;
import java.util.Scanner;

public class User_input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no 1 : ");
        int a = sc.nextInt();
        System.out.println("enter no 2 : ");
        int b = sc.nextInt();
        int c = a+b;
        System.out.println("sum of two no is : "+c);

        boolean b1 = sc.hasNextInt();
        System.out.println(b1);

        String str = sc.nextLine();
        System.out.println(str);
    }
}

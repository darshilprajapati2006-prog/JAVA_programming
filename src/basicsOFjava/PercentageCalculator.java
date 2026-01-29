package basicsOFjava;
import java.util.Scanner;

public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter marks of maths : ");
        int m1 = sc.nextInt();
        System.out.println("enter marks of physics : ");
        int m2 = sc.nextInt();
        System.out.println("enter marks of chemistry : ");
        int m3 = sc.nextInt();
        System.out.println("enter marks of english : ");
        int m4 = sc.nextInt();
        System.out.println("enter marks of computer : ");
        int m5 = sc.nextInt();

        int sum = m1+m2+m3+m4+m5;

        float result = (sum)/5f;

        System.out.println("result = "+result);

    }
}

package OOPs_LAB1;
import java.util.Scanner;


public class p2 {
    public static void main(String[] args) {
         try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter first integer: ");
            int a = sc.nextInt();

            System.out.print("Enter second integer: ");
            int b = sc.nextInt();
            if (a > b) {
                System.out.println(a + " is larger");
            } else if (b > a) {
                System.out.println(b + " is larger");
            } else {
                System.out.println("The numbers are equal");
            }
        }
    }
}


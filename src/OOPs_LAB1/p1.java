package OOPs_LAB1;
import java.util.Scanner;
public class p1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first integer: ");
            int a = sc.nextInt();

            System.out.print("Enter second integer: ");
            int b = sc.nextInt();

            System.out.println("Sum = " + (a + b));
            System.out.println("Product = " + (a * b));
            System.out.println("Difference = " + (a - b));

            if (b != 0) {
                System.out.println("Quotient = " + (a / b));
            } else {
                System.out.println("Quotient = Not defined (division by zero)");
            }
        }
    }
}



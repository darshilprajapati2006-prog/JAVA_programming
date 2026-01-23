package OOPs_LAB1;
import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter radius (integer): ");
            int radius = sc.nextInt();

            double pi = 3.14159; // you can also use Math.PI

            double diameter = 2 * radius;
            double circumference = 2 * pi * radius;
            double area = pi * radius * radius;

            System.out.println("Diameter = " + diameter);
            System.out.println("Circumference = " + circumference);
            System.out.println("Area = " + area);
        }
    }
}


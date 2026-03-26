package OOPs_LAB7;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (in %): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter number of months: ");
        int months = scanner.nextInt();

        double years = months / 12.0;
        double interest = principal * (annualRate / 100.0) * years;
        double balance = principal + interest;

        System.out.printf("Total interest: %.2f%n", interest);
        System.out.printf("Balance after %d months: %.2f%n", months, balance);

        scanner.close();
    }
}

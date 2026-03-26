import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter annual interest rate (in %): ");
            double annualRatePercent = scanner.nextDouble();

            System.out.print("Enter number of months: ");
            int months = scanner.nextInt();

            double years = months / 12.0;
            double annualRateDecimal = annualRatePercent / 100.0;
            double interest = principal * annualRateDecimal * years;
            double balance = principal + interest;

            System.out.printf("Simple interest = %.2f%n", interest);
            System.out.printf("Balance after %d months = %.2f%n", months, balance);
        }
    }
}

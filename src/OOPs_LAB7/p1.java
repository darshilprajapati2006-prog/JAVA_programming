package OOPs_LAB7;

import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInvestmentException extends Exception {
    public InvalidInvestmentException(String message) {
        super(message);
    }
}

class SimpleInterestAccount {
    private double principal;
    private double annualRate;
    private int months;

    public SimpleInterestAccount(double principal, double annualRate, int months)
            throws InvalidInvestmentException {
        setPrincipal(principal);
        setAnnualRate(annualRate);
        setMonths(months);
    }

    public void setPrincipal(double principal) throws InvalidInvestmentException {
        if (principal <= 0) {
            throw new InvalidInvestmentException("Principal amount 0 se greater hona chahiye.");
        }
        this.principal = principal;
    }

    public void setAnnualRate(double annualRate) throws InvalidInvestmentException {
        if (annualRate < 0) {
            throw new InvalidInvestmentException("Interest rate negative nahi ho sakta.");
        }
        this.annualRate = annualRate;
    }

    public void setMonths(int months) throws InvalidInvestmentException {
        if (months <= 0) {
            throw new InvalidInvestmentException("Months 0 se greater hone chahiye.");
        }
        this.months = months;
    }

    public double calculateYears() {
        return months / 12.0;
    }

    public double calculateInterest() {
        return principal * (annualRate / 100.0) * calculateYears();
    }

    public double calculateBalance() {
        return principal + calculateInterest();
    }

    public String getSummary() {
        return String.format(
                "Principal Amount: %.2f%nAnnual Interest Rate: %.2f%%%nMonths: %d%nTotal Interest: %.2f%nFinal Balance: %.2f",
                principal, annualRate, months, calculateInterest(), calculateBalance());
    }
}

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter annual interest rate (in %): ");
            double annualRate = scanner.nextDouble();

            System.out.print("Enter number of months: ");
            int months = scanner.nextInt();

            SimpleInterestAccount account = new SimpleInterestAccount(principal, annualRate, months);
            System.out.println("\nInvestment Details");
            System.out.println(account.getSummary());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Numeric values hi enter karo.");
        } catch (InvalidInvestmentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}

package mid_exam;

import java.util.Scanner;

public class p11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int accountNumber;
        double beginningBalance;
        double totalCharges;
        double totalCredits;
        double creditLimit;

        System.out.println("Enter account number (-1 to stop): ");
        accountNumber = sc.nextInt();

        while(accountNumber != -1)
        {
            System.out.println("Enter beginning balance: ");
            beginningBalance = sc.nextDouble();

            System.out.println("Enter total charges: ");
            totalCharges = sc.nextDouble();

            System.out.println("Enter total credits: ");
            totalCredits = sc.nextDouble();

            System.out.println("Enter credit limit: ");
            creditLimit = sc.nextDouble();

            double newBalance = beginningBalance + totalCharges - totalCredits;

            System.out.println("New balance = " + newBalance);

            if(newBalance > creditLimit)
            {
                System.out.println("Credit limit exceeded.");
            }

            System.out.println();
            System.out.println("Enter next account number (-1 to stop): ");
            accountNumber = sc.nextInt();
        }

        sc.close();
    }
}

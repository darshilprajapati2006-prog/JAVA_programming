package OOPs_LAB2;

import java.util.Scanner;

public class p6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int accountNumber;

        System.out.print("Enter account number (enter -1 to quit): ");
        accountNumber = sc.nextInt();


        while (accountNumber != -1) {

            System.out.print("Enter beginning balance: ");
            double beginningBalance = sc.nextDouble();

            System.out.print("Enter total charges this month: ");
            double totalCharges = sc.nextDouble();

            System.out.print("Enter total credits this month: ");
            double totalCredits = sc.nextDouble();

            System.out.print("Enter credit limit: ");
            double creditLimit = sc.nextDouble();

            double newBalance = beginningBalance + totalCharges - totalCredits;

            System.out.println("New balance is: " + newBalance);

            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded");
            }

            System.out.println();
            System.out.print("Enter account number (enter -1 to quit): ");
            accountNumber = sc.nextInt();
        }

        sc.close();
    }
}

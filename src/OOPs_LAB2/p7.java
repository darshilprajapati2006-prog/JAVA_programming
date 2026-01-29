package OOPs_LAB2;

import java.util.Scanner;

public class p7 {

    public static double calculateCharges(double hours) {

        double charge = 2.0; // minimum charge for up to 3 hours

        if (hours > 3) {
            charge = charge + (hours - 3) * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0; // maximum charge
        }

        return charge;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double hours;
        double totalReceipts = 0.0;

        System.out.print("Enter hours parked (enter -1 to stop): ");
        hours = sc.nextDouble();

        while (hours != -1) {

            double charge = calculateCharges(hours);

            System.out.println("Parking charge for customer: $" + charge);

            totalReceipts += charge;

            System.out.println("Running total of receipts: $" + totalReceipts);

            System.out.print("\nEnter hours parked (enter -1 to stop): ");
            hours = sc.nextDouble();
        }

        sc.close();
    }
}

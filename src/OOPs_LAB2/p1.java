package OOPs_LAB2;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Total miles driven per day: ");
            double milesPerDay = sc.nextDouble();

            System.out.print("Cost per gallon of gasoline: ");
            double costPerGallon = sc.nextDouble();

            System.out.print("Average miles per gallon: ");
            double milesPerGallon = sc.nextDouble();

            System.out.print("Average fees per day: ");
            double feesPerDay = sc.nextDouble();

            System.out.print("Tolls per day: ");
            double tollsPerDay = sc.nextDouble();

            double gasCostPerDay = (milesPerDay / milesPerGallon) * costPerGallon;
            double totalCostPerDay = gasCostPerDay + feesPerDay + tollsPerDay;

            System.out.println("Gas cost per day = " + gasCostPerDay);
            System.out.println("Total driving cost per day = " + totalCostPerDay);
        }
    }
}


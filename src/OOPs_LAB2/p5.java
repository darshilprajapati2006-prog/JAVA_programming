package OOPs_LAB2;

import java.util.Scanner;

public class p5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int miles;
        int gallons;

        int totalMiles = 0;
        int totalGallons = 0;

        System.out.print("Enter miles driven (enter -1 to quit): ");
        miles = sc.nextInt();


        while (miles != -1) {

            System.out.print("Enter gallons used: ");
            gallons = sc.nextInt();

            double milesPerGallon = (double) miles / gallons;
            System.out.println("Miles per gallon for this trip: " + milesPerGallon);

            totalMiles += miles;
            totalGallons += gallons;

            double combinedMPG = (double) totalMiles / totalGallons;
            System.out.println("Combined miles per gallon: " + combinedMPG);

            System.out.print("\nEnter miles driven (enter -1 to quit): ");
            miles = sc.nextInt();
        }

        sc.close();
    }
}
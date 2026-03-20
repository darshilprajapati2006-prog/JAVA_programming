package mid_exam;

import java.util.Scanner;

class DrivingCost
{
    double miles;
    double costPerGallon;
    double parkingFees;
    double tolls;

    DrivingCost(double m,double c,double p,double t)
    {
        miles = m;
        costPerGallon = c;
        parkingFees = p;
        tolls = t;
    }

    void calculateCost()
    {
        double fuelCost = miles * costPerGallon;

        double totalCost = fuelCost + parkingFees + tolls;

        System.out.println("Daily Driving Cost = " + totalCost);
    }
}

public class p7
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        double miles,cost,fees,tolls;

        System.out.println("Enter miles driven per day:");
        miles = sc.nextDouble();

        System.out.println("Enter cost per gallon:");
        cost = sc.nextDouble();

        System.out.println("Enter parking fees per day:");
        fees = sc.nextDouble();

        System.out.println("Enter tolls per day:");
        tolls = sc.nextDouble();

        DrivingCost obj = new DrivingCost(miles,cost,fees,tolls);

        obj.calculateCost();
    }
}
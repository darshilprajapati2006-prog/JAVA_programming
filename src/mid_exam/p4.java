package mid_exam;

import java.util.Scanner;

public class p4
{
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        int radius;

        double diameter, circumference, area;

        double pi = 3.14159;

        System.out.println("Enter radius of circle:");

        radius = sc.nextInt();

        diameter = 2 * radius;

        circumference = 2 * pi * radius;

        area = pi * radius * radius;

        System.out.println("Diameter = " + diameter);

        System.out.println("Circumference = " + circumference);

        System.out.println("Area = " + area);

    }
}
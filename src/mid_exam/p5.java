package mid_exam;

import java.util.Scanner;

public class p5
{
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        int number;

        System.out.println("Enter a five digit number:");

        number = sc.nextInt();

        int d1 = number / 10000;
        int d2 = (number % 10000) / 1000;
        int d3 = (number % 1000) / 100;
        int d4 = (number % 100) / 10;
        int d5 = number % 10;

        System.out.println(d1 + "   " + d2 + "   " + d3 + "   " + d4 + "   " + d5);

    }
}

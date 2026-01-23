package OOPs_LAB1;
import java.util.Scanner;

interface Operations {
    void input();
    void calculate();
    void display();
}

abstract class CalcBase implements Operations {
    int a, b, c;
    int sum, product, largest, smallest;
    double average;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        a = sc.nextInt();
        System.out.print("Enter second number: ");
        b = sc.nextInt();
        System.out.print("Enter third number: ");
        c = sc.nextInt();
    }

    public void calculate() {
        sum = a + b + c;
        product = a * b * c;
        average = sum / 3.0;

        largest = a;
        if (b > largest) largest = b;
        if (c > largest) largest = c;

        smallest = a;
        if (b < smallest) smallest = b;
        if (c < smallest) smallest = c;
    }
}

class Result extends CalcBase {
    public void display() {
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Product = " + product);
        System.out.println("Largest = " + largest);
        System.out.println("Smallest = " + smallest);
    }
}

public class p3 {
    public static void main(String[] args) {
        Operations obj = new Result();
        obj.input();
        obj.calculate();
        obj.display();
    }
}
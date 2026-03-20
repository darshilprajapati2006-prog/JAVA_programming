package mid_exam;
import java.util.Scanner;

class calculator {
    public int sum(int a, int b)
    {
        return a + b;
    }

    public int product(int a, int b)
    {
        return a * b;
    }

    public int difference(int a, int b)
    {
        return a - b;
    }

    public int quotient(int a, int b) {
        return a / b;
    }
}

public class p1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a, b;

        System.out.println("Enter first number:");
        a = sc.nextInt();

        System.out.println("Enter second number:");
        b = sc.nextInt();

        calculator c = new calculator();

        System.out.println("Sum = " + c.sum(a,b));
        System.out.println("Product = " + c.product(a,b));
        System.out.println("Difference = " + c.difference(a,b));
        System.out.println("Quotient = " + c.quotient(a,b));
    }
}

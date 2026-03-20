package mid_exam;
import java.util.Scanner;


interface Operations
{
    void sum(int a,int b,int c);
    void average(int a,int b,int c);
    void product(int a,int b,int c);
    void largest(int a,int b,int c);
    void smallest(int a,int b,int c);
}

abstract class Numbers
{
    int a,b,c;
}


class Calculate extends Numbers implements Operations
{

    public void sum(int a,int b,int c)
    {
        System.out.println("Sum = "+(a+b+c));
    }

    public void average(int a,int b,int c)
    {
        System.out.println("Average = "+((a+b+c)/3));
    }

    public void product(int a,int b,int c)
    {
        System.out.println("Product = "+(a*b*c));
    }

    public void largest(int a,int b,int c)
    {
        int max=a;

        if(b>max) max=b;
        if(c>max) max=c;

        System.out.println("Largest = "+max);
    }

    public void smallest(int a,int b,int c)
    {
        int min=a;

        if(b<min) min=b;
        if(c<min) min=c;

        System.out.println("Smallest = "+min);
    }

}
public class p3 {
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        int x,y,z;

        System.out.println("Enter first number:");
        x=sc.nextInt();

        System.out.println("Enter second number:");
        y=sc.nextInt();

        System.out.println("Enter third number:");
        z=sc.nextInt();

        Calculate obj = new Calculate();

        obj.sum(x,y,z);
        obj.average(x,y,z);
        obj.product(x,y,z);
        obj.largest(x,y,z);
        obj.smallest(x,y,z);

    }
}

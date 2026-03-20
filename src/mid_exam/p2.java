package mid_exam;
import java.util.Scanner;

class CompareToNo{
    void check(int a,int b){
        if(a>b){
            System.out.println(a+" is greater no");
        }
        else if(b>a){
            System.out.println(b+" is greater no");
        }
        else{
            System.out.println("no equal");
        }
    }
}
public class p2 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int num1, num2;

        System.out.println("Enter first number:");
        num1 = sc.nextInt();

        System.out.println("Enter second number:");
        num2 = sc.nextInt();

        CompareToNo obj = new CompareToNo();

        obj.check(num1, num2);
    }
}

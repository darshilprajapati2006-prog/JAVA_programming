package OOPs_LAB5;
/* ->ALGO:
START
INPUT hours
SET rate = 12
SET taxRate = 0.15
FUNCTION calculateTax(gross)
    RETURN gross * taxRate
FUNCTION calculateNetPay(hours)
    gross = hours * rate
    tax = calculateTax(gross)
    net = gross - tax
    RETURN net
CALL calculateNetPay(hours)
PRINT net pay
END
 */
import java.util.Scanner;

public class p5 {
    static double calculateTax(double gross) {
        return gross * 0.15;
    }

    static double calculateNetPay(double hours) {
        double gross = hours * 12;
        double tax = calculateTax(gross);
        return gross - tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter working hours: ");
        double hours = sc.nextDouble();

        double netPay = calculateNetPay(hours);

        System.out.println("Net Pay: " + netPay);
    }
}
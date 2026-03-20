package OOPs_LAB6;
/* ->ALGO :)
START
INPUT attendees
SET income = attendees * 5
SET cost = 20 + (0.5 * attendees)
SET profit = income - cost
PRINT profit
END
 */

import java.util.Scanner;
public class p2 {
    static double calculateTotalProfit(int attendees) {
        double income = attendees * 5;
        double cost = 20 + (0.5 * attendees);
        return income - cost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of attendees: ");
        int attendees = sc.nextInt();
        double profit = calculateTotalProfit(attendees);
        System.out.println("Total Profit: " + profit);
    }
}

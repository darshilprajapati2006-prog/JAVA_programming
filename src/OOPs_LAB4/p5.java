package OOPs_LAB4;

import java.util.Scanner;

public class p5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter range (a b): ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Enter pattern: ");
        String pattern = sc.next();

        int count = 0;

        for (int i = a; i <= b; i++) {

            String num = String.valueOf(i);

            int index = num.indexOf(pattern);

            while (index != -1) {
                count++;
                index = num.indexOf(pattern, index + 1);
            }
        }

        System.out.println("The number of times " + pattern +
                " occurred between " + a + " and " + b + " is: " + count);

        sc.close();
    }
}

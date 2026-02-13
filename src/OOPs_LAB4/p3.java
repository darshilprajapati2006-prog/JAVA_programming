package OOPs_LAB4;

import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        boolean[] printed = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (count[ch] > n && !printed[ch]) {
                System.out.println(ch);
                printed[ch] = true;
            }
        }

        sc.close();
    }
}

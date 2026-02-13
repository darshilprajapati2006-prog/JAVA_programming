package OOPs_LAB4;

import java.util.Scanner;

public class p4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        boolean[] seen = new boolean[256];
        boolean isPerfect = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (seen[ch]) {
                isPerfect = false;
                break;
            }

            seen[ch] = true;
        }

        if (isPerfect)
            System.out.println("Perfect String");
        else
            System.out.println("Not Perfect String");

        sc.close();
    }
}

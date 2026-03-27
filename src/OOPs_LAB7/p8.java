package OOPs_LAB7;

import java.util.Scanner;

public class p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char lower = Character.toLowerCase(ch);

            if (Character.isLetter(ch)) {
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    result = result + ch;
                } else {
                    result = result + '#';
                }
            } else {
                result = result + ch;
            }
        }

        System.out.println("Updated string: " + result);
        sc.close();
    }
}

package OOPs_LAB8;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = sc.nextLine();

        String result = capitalizeEachWord(text);

        // Overall result table
        System.out.println("\n+------------------------+------------------------+");
        System.out.println("|    Original String     |    Modified String     |");
        System.out.println("+------------------------+------------------------+");
        System.out.printf("| %-22s | %-22s |%n", text, result);
        System.out.println("+------------------------+------------------------+");

        // Word-by-word table
        String[] originalWords = text.split(" ");
        String[] modifiedWords = result.split(" ");

        System.out.println("\n+-------+----------------+------------------+");
        System.out.println("| Word# |  Original Word |  Capitalized Word|");
        System.out.println("+-------+----------------+------------------+");
        for (int i = 0; i < originalWords.length; i++) {
            System.out.printf("|  %-5d| %-14s | %-16s |%n",
                    (i + 1), originalWords[i], modifiedWords[i]);
        }
        System.out.println("+-------+----------------+------------------+");

        sc.close();
    }

    static String capitalizeEachWord(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        char[] chars = text.toCharArray();
        boolean newWord = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newWord = true;
            } else if (newWord) {
                chars[i] = Character.toUpperCase(chars[i]);
                newWord = false;
            }
        }
        return new String(chars);
    }
}
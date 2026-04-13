package OOPs_LAB8;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = sc.nextLine();

        // Find first and last occurrence of "the" (case-insensitive)
        String lowerText = text.toLowerCase();
        int firstPos = lowerText.indexOf("the");
        int lastPos  = lowerText.lastIndexOf("the");

        if (firstPos == -1) {
            System.out.println("The string \"the\" was not found in the input.");
        } else if (firstPos == lastPos) {
            System.out.println("Only one occurrence of \"the\" found at position: " + firstPos);
            System.out.println("Need at least two occurrences to extract a substring.");
        } else {
            System.out.println("\nFirst occurrence of \"the\" at index : " + firstPos);
            System.out.println("Last  occurrence of \"the\" at index : " + lastPos);

            // Extract characters between first and last occurrence (exclusive)
            String extracted = text.substring(firstPos + 3, lastPos);

            System.out.println("\nExtracted substring (between the two occurrences):");
            System.out.println("\"" + extracted + "\"");
        }

        sc.close();
    }
}
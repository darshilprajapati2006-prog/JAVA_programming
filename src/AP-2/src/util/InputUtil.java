package util;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner;

    public InputUtil() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                exitOnClosedInput();
            }
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number. Please enter a valid numeric choice.");
            }
        }
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            exitOnClosedInput();
        }
        return scanner.nextLine().trim();
    }

    public void printHeader(String title) {
        System.out.println();
        System.out.println("========================================");
        System.out.println(title);
        System.out.println("========================================");
    }

    public void pause() {
        System.out.println();
        System.out.print("Press Enter to continue...");
        if (!scanner.hasNextLine()) {
            exitOnClosedInput();
        }
        scanner.nextLine();
    }

    private void exitOnClosedInput() {
        System.out.println();
        System.out.println("Input stream closed. Exiting application safely.");
        System.exit(0);
    }
}

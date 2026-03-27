package OOPs_LAB7;

import java.util.Scanner;

enum Result {
    CORRECT,
    WRONG,
    NOT_ANSWERED
}

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] correctAnswers = {'C', 'A', 'B', 'D'};
        char[] submittedAnswers = new char[4];

        for (int i = 0; i < submittedAnswers.length; i++) {
            System.out.print("Enter answer for question " + (i + 1) + ": ");
            submittedAnswers[i] = Character.toUpperCase(sc.next().charAt(0));
        }

        int correctCount = 0;
        int wrongCount = 0;

        System.out.println("QUESTION\tSUBMITTED ANS\tCORRECT ANS\tRESULT");

        for (int i = 0; i < correctAnswers.length; i++) {
            Result result;

            if (submittedAnswers[i] == 'X') {
                result = Result.NOT_ANSWERED;
            } else if (submittedAnswers[i] == correctAnswers[i]) {
                result = Result.CORRECT;
                correctCount++;
            } else {
                result = Result.WRONG;
                wrongCount++;
            }

            System.out.println((i + 1) + "\t\t" + submittedAnswers[i] + "\t\t" + correctAnswers[i] + "\t\t" + result);
        }

        System.out.println();
        System.out.println("No. of correct answers: " + correctCount);
        System.out.println("No. of wrong answers: " + wrongCount);

        if (correctCount >= 2) {
            System.out.println("The candidate passed.");
        } else {
            System.out.println("The candidate failed.");
        }

        sc.close();
    }
}

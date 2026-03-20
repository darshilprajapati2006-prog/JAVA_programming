package OOPs_LAB5;
/* ->algo:
START

DEFINE correctAnswers array

INPUT submittedAnswers array

SET correct = 0
SET wrong = 0
SET unanswered = 0

FOR i = 0 to 7
    IF submitted[i] == 'X'
        result = UNANSWERED
        unanswered++
    ELSE IF submitted[i] == correct[i]
        result = CORRECT
        correct++
    ELSE
        result = WRONG
        wrong++

    PRINT question, submitted, correct, result

PRINT counts

IF correct >= 5
    PRINT PASS
ELSE
    PRINT FAIL

END
 */

import java.util.Scanner;

enum Result {
    CORRECT, WRONG, UNANSWERED
}

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] correct = {'C','A','B','D','B','C','C','A'};
        char[] submitted = new char[8];

        System.out.println("Enter 8 answers (use X for unanswered):");
        for (int i = 0; i < 8; i++) {
            submitted[i] = sc.next().charAt(0);
        }

        int correctCount = 0, wrongCount = 0, unansCount = 0;

        System.out.println("QUESTION SUBMITTED CORRECT RESULT");

        for (int i = 0; i < 8; i++) {
            Result res;

            if (submitted[i] == 'X') {
                res = Result.UNANSWERED;
                unansCount++;
            } else if (submitted[i] == correct[i]) {
                res = Result.CORRECT;
                correctCount++;
            } else {
                res = Result.WRONG;
                wrongCount++;
            }

            System.out.println((i+1) + "        " + submitted[i] + "        " + correct[i] + "       " + res);
        }

        System.out.println("Correct answers: " + correctCount);
        System.out.println("Wrong answers: " + wrongCount);
        System.out.println("Unanswered: " + unansCount);

        if (correctCount >= 5)
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }
}
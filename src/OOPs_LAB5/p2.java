package OOPs_LAB5;
/*
->ALGO:
@ CheckHex(str)
FOR each character ch in string
    IF ch is digit
        CONTINUE
    ELSE IF ch between 'A' and 'F'
        CONTINUE
    ELSE IF ch between 'a' and 'f'
        CONTINUE
    ELSE
        THROW Exception
PRINT "Valid Hexadecimal"
 */



import java.util.Scanner;

class InvalidHexException extends Exception {
    InvalidHexException(String msg) {
        super(msg);
    }
}

public class p2 {
    static void checkHex(String str) throws InvalidHexException {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch) ||
                    (ch >= 'A' && ch <= 'F') ||
                    (ch >= 'a' && ch <= 'f')) {
                continue;
            } else {
                throw new InvalidHexException("Not a Hexadecimal Number");
            }
        }
        System.out.println("Valid Hexadecimal Number");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        try {
            checkHex(str);
        } catch (InvalidHexException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Ending the program");
        }
    }
}
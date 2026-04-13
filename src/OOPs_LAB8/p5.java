package OOPs_LAB8;
import java.util.Scanner;

/*
 * ╔══════════════════════════════╦══════════════════════════════════════════════════╗
 * ║         Concept              ║                   Purpose                        ║
 * ╠══════════════════════════════╬══════════════════════════════════════════════════╣
 * ║  toCharArray()               ║  Converts the string into a character array      ║
 * ║                              ║  for easy manipulation                           ║
 * ╠══════════════════════════════╬══════════════════════════════════════════════════╣
 * ║  Character.toUpperCase(ch)   ║  Converts a character to uppercase               ║
 * ╠══════════════════════════════╬══════════════════════════════════════════════════╣
 * ║  newWord flag                ║  Tracks whether the next character is the        ║
 * ║                              ║  start of a new word                             ║
 * ╠══════════════════════════════╬══════════════════════════════════════════════════╣
 * ║  new String(chars)           ║  Converts the modified char array back to        ║
 * ║                              ║  a String                                        ║
 * ╚══════════════════════════════╩══════════════════════════════════════════════════╝
 */

/*
->LOGIC FLOW:

1.Read a line of text from the console
2.Convert the string to a char[] array
3.Use a boolean flag newWord = true (since the very first character starts a word)
4.Loop through each character:
->If a space is found → set newWord = true
->If newWord is true → capitalize that character, set newWord = false
5.Convert the char array back to a String and print it
*/

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = sc.nextLine();

        String result = capitalizeEachWord(text);

        System.out.println("\n+------------------------+------------------------+");
        System.out.println("|    Original String     |    Modified String     |");
        System.out.println("+------------------------+------------------------+");
        System.out.printf("| %-22s | %-22s |%n", text, result);
        System.out.println("+------------------------+------------------------+");

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
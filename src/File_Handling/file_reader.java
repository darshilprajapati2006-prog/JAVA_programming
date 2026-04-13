package File_Handling;
import java.io.*;
public class file_reader {
    static void main(String[] args) {
        try {
            FileReader f = new FileReader("/Users/darshilprajapati/Library/Mobile Documents/com~apple~CloudDocs/Desktop/LC.txt");
            try {
                int i;
                while ((i = f.read()) != -1) {
                    System.out.println((char) i);
                }
            } finally {
                f.close();
            }
        } catch (IOException i) {
            System.out.println("exception handaled");
        }
    }
}

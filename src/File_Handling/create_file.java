package File_Handling;
import java.io.*;
public class create_file {
    public static void main(String[] args) {
        File f = new File("/Users/darshilprajapati/Library/Mobile Documents/com~apple~CloudDocs/Desktop/LC.txt");
        try {
            if (f.createNewFile()) {
                System.out.println("File Successfully Created..!");
            } else {
                System.out.println("File Already Exists..!");
            }
        }
        catch(IOException e){
            System.out.println("exception handled");
        }
    }
}

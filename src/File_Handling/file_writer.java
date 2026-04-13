package File_Handling;
import java.io.*;
public class file_writer {
    static void main(String[] args) {
        try{
            FileWriter f = new FileWriter("/Users/darshilprajapati/Library/Mobile Documents/com~apple~CloudDocs/Desktop/LC.txt");
           try{
               f.write("learn coding");
           }
           finally {
               f.close();
           }
            System.out.println("succesfully data wrote in file");
        }
        catch(IOException i){
            System.out.println(i);
        }
    }
}

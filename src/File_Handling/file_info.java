package File_Handling;

import java.io.File;

public class file_info {
    public static void main(String[] args) {
        File f = new File("/Users/darshilprajapati/Library/Mobile Documents/com~apple~CloudDocs/Desktop/LC.txt");
        if(f.exists()){
            System.out.println("file name : "+f.getName());
            System.out.println("file location : "+f.getAbsoluteFile());
            System.out.println("file writable : "+f.canWrite());
            System.out.println("file readable : "+f.canRead());
            System.out.println("file size " +f.length());
            System.out.println("file path : "+f.getPath());
        }
        else{
            System.out.println("file doesn't exist");
        }
    }
}

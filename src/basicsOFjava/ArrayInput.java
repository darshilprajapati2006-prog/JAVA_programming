package basicsOFjava;

import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {
        int size;
        Scanner obj = new Scanner(System.in);
        System.out.println("enter the size of an array : ");
        size = obj.nextInt();
        int arr [] = new int[size];
        System.out.println("enter array elements : ");
        for(int i=0;i<size;i++){
            arr[i]=obj.nextInt();
        }
        System.out.println("printed Array elements : ");
        for(int i=0;i<size;i++){
            System.out.println(arr[i]+" ");
        }

    }
}

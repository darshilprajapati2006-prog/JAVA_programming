package OOPs_LAB4;

import java.util.Scanner;

interface Function {
    int evaluate(int value);
}

class Half implements Function {

    public int evaluate(int value) {
        return value / 2;
    }
}

public class p6 {

    public static int[] processArray(int[] arr) {

        Function func = new Half();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = func.evaluate(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] input = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        int[] output = processArray(input);

        System.out.println("Result array:");
        for (int value : output) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}
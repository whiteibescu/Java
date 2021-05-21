package Hustar;

import java.util.Scanner;

public class Day03_02 {
    public static void main(String[] args) {
        final int SIZE = 10;
        int[] arr = new int[SIZE];

        Scanner scanner = new Scanner(System.in);

        InputArray(arr, scanner);
        PrintArray(arr, scanner);


    }

    public static void InputArray(int[] arr, Scanner scanner)
    {
        for (int i = 0; i < 10; ++i)
        {
            arr[i] = scanner.nextInt();
        }
    }

    public static void PrintArray(int[] arr, Scanner scanner)
    {
        for (int i = 0; i < arr.length; ++i)
        {
            System.out.println(arr[i]);
        }
    }

}

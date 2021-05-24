package Hustar;

import java.util.Scanner;

public class Day03_02 {
    public static void main(String[] args) {
        final int SIZE = 10;
        int[] arr = new int[SIZE];

        Scanner scanner = new Scanner(System.in);

/*        InputArray(arr, scanner);
        PrintArray(arr, scanner);*/
/*        LectureCoding(arr, scanner);*/
    }

    public static void InputArray(int[] arr, Scanner scanner)
    {
        for (int i = 0; i < arr.length; ++i)
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

    public static void LectureCoding(int[] arr, Scanner scanner)
    {
        boolean isQuit = false;
        for (int i = 0; !isQuit && i < arr.length; ++i)
        while(true)
        {
            try {
                System.out.format("Input arr[%d]: ", i);
                String str = scanner.next();
                if (str.equals("quit")){
                    isQuit = true;
                    break;
                }
                int val = Integer.parseInt(str);
                arr[i] = val;
                break;
            } catch (Exception e)
            {
                // error handling
            }
        }

    }

    public static void TickTackToe()
    {
        final int BLACK = 0;
        final int PLAYER_0 = 1;
        final int Player_X = 2;

        final int WIDTH = 3;
        final int HEIGHT = 3;

        int[] arr = new int[WIDTH * HEIGHT];


        System.out.println("0 |   | X");
        System.out.println("0 | X | X");
        System.out.println("0 | X | X");

        System.out.println("\nPlayer [1] (x, y)> ") ;
        System.out.println("\nPlayer [2] (x, y)> ") ;
    }


}

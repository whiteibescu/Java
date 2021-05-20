package Hustar;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {51, 52, 3, 74, 5, 16, 27};
        int max;
        int sum = 0;

        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }
        int avg = sum / arr.length;

        Arrays.sort(arr);

        System.out.println("이 배열의 최대값은 => " + arr[arr.length - 1]);
        System.out.println("이 배열의 최소값은 => " + arr[0]);
        System.out.println("합은 =>" + sum);
        System.out.println("평균은 =>" + avg);

    }
}

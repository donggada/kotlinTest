package com.example.kotlinTest.백준_DP;

import java.util.Scanner;

public class Test10870 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(bottomUp(n + 1));
        System.out.println(topDown(n + 1));
    }

    //bottom-up
    private static int bottomUp(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length ; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n - 1];
    }



    //top-down
    private static int topDown(int n) {
        int[] arr = new int[n];

       return dp(n-1,  arr);
    }

    private static int dp(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        arr[n] = dp(n-1, arr) + dp(n-2, arr);

        return arr[n];
    }
}

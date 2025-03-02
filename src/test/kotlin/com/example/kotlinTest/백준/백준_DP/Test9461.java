package com.example.kotlinTest.백준.백준_DP;

import java.util.Scanner;

public class Test9461 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T ; i++) {
            int n = scanner.nextInt();
            System.out.println(bottomUp(n));
        }


    }

    private static Long bottomUp(int n) {
        Long[] arr = new Long[101];

        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        for (int i = 4; i < 101 ; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }

        return arr[n];
    }
}

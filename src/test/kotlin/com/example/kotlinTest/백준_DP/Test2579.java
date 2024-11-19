package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2579 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];


        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

//        System.out.println(bottomUp(n));
        System.out.println(topDown(n));
    }

    private static int topDown(int n) {
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        if (dp[n] == 0) {
             dp[n] = Math.max(topDown(n-2), topDown(n-3) + arr[n-1]) + arr[n];
        }

        return dp[n];
    }

    private static int bottomUp(int n) {
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n ; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        return dp[n];
    }
}

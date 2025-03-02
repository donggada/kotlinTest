package com.example.kotlinTest.백준.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());

        arr = new int[n+1];

        for (int i = 1; i < n+1 ; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        bottomUp();
        topDown();
    }

    private static void bottomUp() {
        int[] dp = new int[n+1];
        dp[1] = arr[1];

        if (n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i < n+1  ; i++) {
            dp[i] = Math.max(dp[i-1], arr[i] + Math.max(dp[i-2], dp[i-3] + arr[i-1]));
        }

        System.out.println(dp[n]);
    }

    private static void topDown() {
        Integer[] dp = new Integer[n+1];
        dp[0] = 0;
        dp[1] = arr[1];

        if (n > 1) {
            dp[2] = arr[1] + arr[2];
        }


        System.out.println(topDownProcess(n, dp));
    }

    private static int topDownProcess(int n, Integer[] dp) {
        if (dp[n] == null) {
            dp[n] = Math.max(topDownProcess(n-1, dp), arr[n] + Math.max(topDownProcess(n-2, dp), topDownProcess(n-3, dp) + arr[n-1]));
        }

        return dp[n];
    }
}

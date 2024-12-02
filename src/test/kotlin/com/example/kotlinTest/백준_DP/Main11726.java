package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11726 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());

        bottomUp();
    }

    private static void bottomUp() {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1 ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}

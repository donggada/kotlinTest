package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        Integer n = Integer.valueOf(s[0]);
        Integer k = Integer.valueOf(s[1]);

        int[][] arr = new int[n+1][2];
        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i < n+1 ; i++) {
            String[] sp = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(sp[0]);
            arr[i][1] = Integer.valueOf(sp[1]);
        }

        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < k+1 ; j++) {
                dp[i][j] = dp[i-1][j];
                int gap = j - arr[i][0];
                if (gap > -1) {
                    dp[i][j] = Math.max(dp[i][j], arr[i][1] + dp[i-1][gap]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}

package com.example.kotlinTest.백준.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.valueOf(s[0]);
        int M = Integer.valueOf(s[1]);

        int [][] arr = new int[N+1][M+1];
        int [][] dp = new int[N+1][M+1];

        for (int i = 1; i < N + 1 ; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.valueOf(sp[j-1]);
            }
        }

        for (int i = 1; i < N + 1 ; i++) {
            for (int j = 1; j < M+1 ; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[N][M]);
    }

}
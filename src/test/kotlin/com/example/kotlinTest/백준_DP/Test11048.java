package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);



        int[][] dp = new int[N+1][M+1];
        int[][] map = new int[N+1][M+1];
        for (int i = 1; i <= N ; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(sp[j-1]);
            }
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                dp[i][j] = Math.max(map[i][j] + dp[i-1][j], map[i][j]+ dp[i][j-1]);
            }
        }

        System.out.println(dp[N][M]);
    }
}

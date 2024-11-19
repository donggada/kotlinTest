package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1149 {
    static int[][] arr;
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        arr = new int[N][3];
        dp = new int[N][3];


        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.valueOf(s[j]);
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        System.out.println(Math.min(Math.min(topDown(N-1,0), topDown(N-1,1)), topDown(N-1,2)));

//        bottomUp();
    }

    private static void bottomUp() {
        for (int i = 1; i < N; i++) {
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }

        int[] result = arr[N - 1];
        Arrays.sort(result);
        System.out.println(result[0]);
    }

    private static int topDown(int house, int color) {
        if(dp[house][color] == 0) {
            if(color == 0) {
                dp[house][0] = Math.min(topDown(house - 1, 1), topDown(house - 1, 2)) + arr[house][0];
            }
            else if(color == 1) {
                dp[house][1] = Math.min(topDown(house - 1, 0), topDown(house- 1, 2)) + arr[house][1];
            }
            else {
                dp[house][2] = Math.min(topDown(house - 1, 0), topDown(house - 1, 1)) + arr[house][2];
            }

        }

        return dp[house][color];
    }
}

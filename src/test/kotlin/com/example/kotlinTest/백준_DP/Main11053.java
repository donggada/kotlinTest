package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11053 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        arr = new int[n];
        dp = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }


        bottomUp();

    }

    private static void bottomUp() {
        for (int i = 0; i < arr.length ; i++) {
            dp[i] = 1;

            for (int j = 0; j < i ; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[arr.length-1]);
    }

}

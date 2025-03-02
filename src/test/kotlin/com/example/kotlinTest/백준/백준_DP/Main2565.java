package com.example.kotlinTest.백준.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2565 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(s[0]);
            arr[i][1] = Integer.valueOf(s[1]);
        }
        dp();
    }

    private static void dp() {
        int[] dp = new int[n];

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(n - dp[n - 1]);
    }
}

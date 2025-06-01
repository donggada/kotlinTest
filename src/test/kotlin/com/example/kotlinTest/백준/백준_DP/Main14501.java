package com.example.kotlinTest.백준.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            t[i] = Integer.parseInt(s[0]);
            v[i] = Integer.parseInt(s[1]);
        }

        int[] dp = new int[n+1];

        for (int i = 0; i < n ; i++) {
            int time = i + t[i];
            if (time <= n) {
                dp[time] = Math.max(dp[time], dp[i] + v[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }

}

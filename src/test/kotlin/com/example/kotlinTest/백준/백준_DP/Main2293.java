package com.example.kotlinTest.백준.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2293 {
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        Integer n = Integer.valueOf(s[0]);
        Integer k = Integer.valueOf(s[1]);
        coin = new int[n+1];
        dp = new int[k+1];

        for (int i = 0; i < n ; i++) {
            coin[i+1] = Integer.valueOf(br.readLine());
        }

        dp[0] = 1;
        bottomUp(k);
    }
    
    private static void bottomUp(int k) {
        for (int i = 1; i < coin.length ; i++) {
            for (int j = coin[i]; j < k + 1 ; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    } 
}

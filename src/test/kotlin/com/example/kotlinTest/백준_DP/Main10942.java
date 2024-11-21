package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10942 {
    static int[] arr;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.valueOf(br.readLine());

        arr  = new int[N+1];
        dp = new boolean[N+1][N+1];
        String[] s = br.readLine().split(" ");

        for (int i = 1; i < N + 1 ; i++) {
            arr[i] = Integer.valueOf(s[i-1]);
        }


        Integer M = Integer.valueOf(br.readLine());

        StringBuffer result = new StringBuffer();

        dp(N);
        for (int i = 0; i < M ; i++) {
            String[] parts = br.readLine().split(" ");
            if (dp[Integer.valueOf(parts[0])][Integer.valueOf(parts[1])]) {
                result.append("1").append("\n");
                continue;
            }
            result.append("0").append("\n");
        }

        System.out.println(result);

    }

    private static void dp (int n) {
        // S ~ E의 길이가 1일 때(즉, 한 개의 수만 선택했을 때)
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        // S ~ E의 길이가 2일 때(즉, 두 개의 수만 선택했을 때)
        for (int i = 1; i <= n-1 ; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
            }
        }

        // S ~ E의 길이가 3 이상일 때
        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                int k = j + i - 1;
                //양 끝의 두 문자가 같고,
                //양 끝의 두 문자를 제외하고 안에 있는 단어가 팰린드롬이면
                if (arr[j] == arr[k] && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                }
            }
        }

    }

    private static boolean binarySearch(String parts) {
        String[] indexParts = parts.split(" ");
        Integer start = Integer.valueOf(indexParts[0]);
        Integer end = Integer.valueOf(indexParts[1]);
        int mid = (start + end) / 2;
        int right = end;

        for (int left = start; left < mid; left++) {
            if(arr[left-1] != arr[right-1]) {
                return false;
            }
            right--;
        }

        return true;
    }
}
package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 지동자동구축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        int row = 1;
        dp[0] = 2;
        dp[1] = 3;

        for (int i = 2; i < n+1; i++ ) {
            row *= 2;
            dp[i] = dp[i-1] + row;
        }
        System.out.println(dp[n-1] * dp[n-1]);

        new ArrayList<>().stream().forEach(System.out::println);
    }
}

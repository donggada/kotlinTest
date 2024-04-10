package com.example.kotlinTest.백준_완전탐색;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] dayArray = new int[N];
        int [] valueArray = new int[N];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            dayArray[i] = Integer.parseInt(split[0]);
            valueArray[i] = Integer.parseInt(split[1]);
        }

        for (int i = 0; i < N ; i++) {
            int nextDay = i + dayArray[i];
            if (nextDay <= N) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + valueArray[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);


    }

}

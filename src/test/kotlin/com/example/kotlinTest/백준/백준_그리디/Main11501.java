package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] chart = new int[n];
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < n ; j++) {
                chart[j] = Integer.parseInt(s[j]);
            }

            sb.append(cal(chart)).append("\n");
        }
        System.out.println(sb);
    }

    private static int cal (int[] chart) {
        int result = 0;
        int cost = 0;
        for (int i = chart.length - 1; i > -1 ; i--) {
            if (chart[i] > cost) {
                cost = chart[i];
                continue;
            }

            result += cost - chart[i];
        }

        return result;
    }
}

package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1932 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < split.length ; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j <= i ; j++) {
                if (j == 0) {
                    arr[i][j] += arr[i-1][j];
                    continue;
                }

                if (j == i) {
                    arr[i][j] += arr[i-1][j-1];
                    continue;
                }

                arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + arr[i][j];
            }
        }

        System.out.println(Arrays.stream(arr[n - 1]).max().getAsInt());
    }

}

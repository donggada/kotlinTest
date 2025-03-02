package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N ; i++) {
            max = Math.max(max, arr[i] * (N - i));
        }

        System.out.println(max);
    }
}

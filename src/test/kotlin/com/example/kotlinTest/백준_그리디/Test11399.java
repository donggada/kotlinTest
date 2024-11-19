package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int sum = 0;
        int time = 0;

        for (int i = 0; i < N ; i++) {
            sum += time + arr[i];
            time += arr[i];
        }

        System.out.println(sum);
    }
}

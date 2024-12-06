package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        Integer n = Integer.valueOf(s[0]);
        Integer k = Integer.valueOf(s[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(arr);

        int index = n-1;
        int count = 0;

        while (k != 0 && index > -1) {
            count += k / arr[index];
            k %= arr[index];
            index--;
        }

        System.out.println(count);
    }
}

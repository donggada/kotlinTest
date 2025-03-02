package com.example.kotlinTest.백준.백준_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Integer N = Integer.valueOf(s[0]);
        Integer M = Integer.valueOf(s[1]);

        int[] arr = new int[N];
        String[] sp = br.readLine().split(" ");
        int max = 0;
        int min = 0;
        for (int i = 0; i < N ; i++) {
            Integer n = Integer.valueOf(sp[i]);
            max = Math.max(max, n);
            arr[i] = n;
        }


        while (min < max) {
            int mid =  (min + max) / 2;

            long sum = 0;

            for (int n : arr) {
                int gap = n - mid;
                if (gap > 0) {
                    sum += gap;
                }
            }

            if (sum < M) {
                max = mid;
                continue;
            }

            min = mid + 1;
        }

        System.out.println(min-1);
    }
}

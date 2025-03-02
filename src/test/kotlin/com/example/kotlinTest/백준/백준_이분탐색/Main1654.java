package com.example.kotlinTest.백준.백준_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        Integer K = Integer.valueOf(s[0]);
        Integer N = Integer.valueOf(s[1]);

        int[] arr = new int[K];


        long min = 0;
        long max = 0;

        for (int i = 0; i < K; i++) {
            Integer n = Integer.valueOf(br.readLine());
            arr[i] = n;
            max = Math.max(max, n);
        }

        max++;
        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (int n :arr) {
                count += n / mid;
            }

            if (count < N) {
                max = mid;
                continue;
            }

            min = mid + 1;
        }

        System.out.println(min-1);
    }
}

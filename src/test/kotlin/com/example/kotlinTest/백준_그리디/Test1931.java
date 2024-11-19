package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N ; i++) {
            String[] s = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, (arr1, arr2) -> arr1[1] == arr2[1] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);

        int startTime = 0;
        int count = 0;

        for (int[] a : arr) {
            if (startTime <= a[0]) {
                startTime = a[1];
                count++;
            }
        }

        System.out.println(count);
    }
}

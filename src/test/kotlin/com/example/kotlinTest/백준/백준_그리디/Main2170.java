package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2170 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.valueOf(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N ; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(s[0]);
            arr[i][1] = Integer.valueOf(s[1]);
        }


        Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0]? arr1[1] - arr2[1] : arr1[0] - arr2[0]);

        int start = arr[0][0];
        int end = arr[0][1];
        int len = end - start;

        for (int i = 1; i < N ; i++) {
            if (start < arr[i][0] && end > arr[i][1]) {
                continue;
            }

            if (end >= arr[i][0]) {
                len += arr[i][1] - end;
            }

            if (end < arr[i][0]) {
                len += arr[i][1] - arr[i][0];
            }

            start = arr[i][0];
            end = arr[i][1];
        }

        System.out.println(len);
    }
}



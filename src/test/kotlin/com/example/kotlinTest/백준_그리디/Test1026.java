package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Test1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");

        int arr1[] = new int[N];
        int arr2[] = new int[N];

        for (int i = 0; i < N ; i++) {
            arr1[i] = Integer.parseInt(s1[i]);
            arr2[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int result = 0;
        for (int i = 0; i < N ; i++) {
            result += arr1[i] * arr2[N-i-1];
        }

        System.out.println(result);
    }
}

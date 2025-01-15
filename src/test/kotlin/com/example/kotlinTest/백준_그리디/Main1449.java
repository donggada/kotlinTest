package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);
        int[] arr = new int[n];

        String[] sp = br.readLine().split(" ");

        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(sp[i]);
        }

        Arrays.sort(arr);

        int count = 0;
        int tapeLen = 0;
        for (int len : arr) {
            if (tapeLen < len - 0.5) {
                tapeLen = (int) (len - 0.5 + l);
                count++;
            }
        }

        System.out.println(count);
    }
}

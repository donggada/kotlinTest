package com.example.kotlinTest.백준.백준_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int[] arr = new int[7];

        arr[Integer.parseInt(s[0])]++;
        arr[Integer.parseInt(s[1])]++;
        arr[Integer.parseInt(s[2])]++;

        int max = 0;
        for (int i = 1; i < 7 ; i++) {
            if (arr[i] == 2) {
                System.out.println(i * 100 + 1000);
                return;
            }

            if (arr[i] == 3) {
                System.out.println(i * 1000 + 10000);
                return;
            }

            if (arr[i] == 1) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max * 100);

    }

}

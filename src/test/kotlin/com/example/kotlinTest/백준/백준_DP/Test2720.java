package com.example.kotlinTest.백준.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] arr = {25, 10, 5, 1};
        for (int i = 0; i < testCase ; i++) {
            int[] result = new int[4];
            int amount = Integer.parseInt(br.readLine());
            for (int j = 0; j < 4 ; j++) {
                result[j] = amount / arr[j];
                amount = amount % arr[j];
            }

            for (int n :result) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

package com.example.kotlinTest.백준.백준_수학적문제해결;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test1037 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[0] * arr[n-1]);
    }
}

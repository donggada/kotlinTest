package com.example.kotlinTest.백준.백준_수학적문제해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);

        if (start == 1) {
            start += 1;
        }

        if (start == 0) {
            start += 2;
        }

        for (int i = start; i <= end ; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i*i <= n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

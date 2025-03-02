package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2839 {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        System.out.println(cal(n));
    }
    private static int cal(int n) {
        if (n == 4 || n == 7) {
            return -1;
        }

        if (n % 5 == 0) {
            return (n / 5);
        }

        // ex 6 ,8 값에 + 5 한 숫자임
        if (n % 5 == 1 || n % 5 == 3) {
            return (n / 5) + 1;
        }
        // ex 12 ,9 값에 + 5 한 숫자임
        if (n % 5 == 2 || n % 5 == 4) {
            return (n / 5) + 2;
        }

        return -1;
    }

}

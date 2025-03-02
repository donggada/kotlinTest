package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] m = {500, 100, 50, 10, 5 ,1};

        int n = Integer.parseInt(br.readLine());

        int change = 1000 - n;

        int count = 0;


        for (int i = 0; i <m.length ; i++) {
            count += change / m[i];
            change = change % m[i];
            if (change == 0) {
                System.out.println(count);
                return;
            }
        }
    }
}

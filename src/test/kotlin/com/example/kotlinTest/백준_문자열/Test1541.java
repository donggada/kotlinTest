package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] split = s.split("-");

        int total = Integer.MAX_VALUE;

        for (int i = 0; i < split.length ; i++) {
            int sum = 0;
            String[] arr = split[i].split("[+]");

            for (int j = 0; j <arr.length ; j++) {
                sum += Integer.parseInt(arr[j]);
            }

            if (total == Integer.MAX_VALUE) {
                total = sum;
                continue;
            }

            total -= sum;
        }

        System.out.println(total);
    }
}

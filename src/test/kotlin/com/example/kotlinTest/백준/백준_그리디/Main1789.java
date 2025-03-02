package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long count = 0;
        long s = Long.parseLong(br.readLine());
        long sum = 0;
        long index = 1;

        while (s >= sum) {
            sum += index;
            index++;
            count++;
        }
        System.out.println(count -1);
    }


}

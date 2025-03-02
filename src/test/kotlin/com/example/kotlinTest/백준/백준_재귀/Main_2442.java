package com.example.kotlinTest.백준.백준_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N-i-1; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < 2*i+1; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}

package com.example.kotlinTest.백준_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1330 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int left = Integer.parseInt(s[0]);
        int right = Integer.parseInt(s[1]);

        if (left > right) {
            System.out.println(">");
            return;
        }

        if (left < right) {
            System.out.println("<");
            return;
        }

        System.out.println("==");
    }
}

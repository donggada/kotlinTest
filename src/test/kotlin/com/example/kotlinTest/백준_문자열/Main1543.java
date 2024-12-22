package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String s = br.readLine();

        System.out.println((word.length() - word.replaceAll(s, "").length()) / s.length());
    }
}

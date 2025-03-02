package com.example.kotlinTest.백준.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] sp = s.split(" ");

        System.out.println(Math.max(stringToInt(sp[0]), stringToInt(sp[1])));
    }

    private static int stringToInt(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i > -1 ; i--) {
            sb.append(str.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}

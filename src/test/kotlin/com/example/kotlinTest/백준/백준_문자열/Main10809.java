package com.example.kotlinTest.백준.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[26];

        Arrays.fill(arr , -1);

        for (int i = 0; i <s.length() ; i++) {
            int index = s.charAt(i) - 'a';

            if (arr[index] == -1) {
                arr[index] = i;
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}

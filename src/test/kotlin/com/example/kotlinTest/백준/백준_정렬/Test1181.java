package com.example.kotlinTest.백준.백준_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N ; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> s1.length() != s2.length() ? s1.length() - s2.length() : s1.compareTo(s2));
        String before = "";
        for (String s : arr) {
            if (!s.equals(before)) {
                System.out.println(s);
                before = s;
            }

        }
    }
}

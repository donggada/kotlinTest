package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int value = 9;
        int [] arr = new int[26];
        int index = 25;
        int result = 0;

        for (int i = 0; i < n ; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length() ; j++) {
                char key = s.charAt(j);

                arr[s.charAt(j) - 'A'] += (int) Math.pow(10, s.length() - 1 - j);
            }
        }


        Arrays.sort(arr);

        while (arr[index] > 0) {
            result +=arr[index] * value;
            value--;
            index--;
        }



        System.out.println(result);
    }
}

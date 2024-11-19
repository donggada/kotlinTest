package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나무공격 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);

        int[] arr = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            for (String str : sp) {
                if (str.equals("1")) {
                    arr[i]++;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            String[] sp = br.readLine().split(" ");
            int start = Integer.parseInt(sp[0]) - 1;
            int end = Integer.parseInt(sp[1]) - 1;

            for (int index = start; index <= end; index++) {
                if (arr[index] > 0) {
                    arr[index]--;
                }

            }
        }

        for(int count : arr) {
            result += count;
        }

        System.out.println(result);
    }

}

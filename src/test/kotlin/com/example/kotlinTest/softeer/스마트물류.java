package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스마트물류 {
    static String[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Integer N = Integer.valueOf(s[0]);
        Integer K = Integer.valueOf(s[1]);

        arr = br.readLine().split("");
        visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i].equals("P") && check(i, K)) {
                count++;
            }
        }

        System.out.println(count);

    }
    private static boolean check (int index, int k) {
        for (int i = k-1; i > -1; i--) {
            int idx1 = index + i + 1;
            int idx2 = index - i - 1;

            if (idx2 > -1) {
                if (arr[idx2].equals("H") && !visited[idx2]) {
                    visited[idx2] = true;
                    return true;
                }
            }

            if (idx1 < arr.length) {
                if (arr[idx1].equals("H") && !visited[idx1]) {
                    visited[idx1] = true;
                    return true;
                }
            }

        }

        return false;
    }
}

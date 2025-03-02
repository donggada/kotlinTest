package com.example.kotlinTest.백준.백준_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16234 {
    static int n;
    static int l;
    static int r;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        arr = new int[n][n];

        for (int i = 0; i < n ; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 0; j < n ; j++) {
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }


    }

    private static int move() {
        return 1;
    }
}

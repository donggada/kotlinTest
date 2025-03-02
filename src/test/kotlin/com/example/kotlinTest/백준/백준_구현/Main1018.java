package com.example.kotlinTest.백준.백준_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1018 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        arr = new char[n][m];
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < n ; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <n -7; i++) {
            for (int j = 0; j < m -7; j++) {
                count = Math.min(count, calCount(i, j));
            }
        }

        System.out.println(count);
    }

    private static int  calCount(int x, int y) {
        int count = 0;
        char color = arr[x][y];

        for (int i = x; i < x + 8 ; i++) {
            for (int j = y; j < y + 8 ; j++) {
                if(color != arr[i][j]) {
                    count++;
                }

                if (color == 'W') {
                    color = 'B';
                    continue;
                }
                color = 'W';
            }
            if (color == 'W') {
                color = 'B';
                continue;
            }
            color = 'W';
        }

        return Math.min(count, 64- count);
    }
}

package com.example.kotlinTest.백준.백준_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 1; j <= n ; j++) {
                arr[i][j] = arr[i][j-1] + Integer.parseInt(sp[j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m ; i++) {
            String[] sp = br.readLine().split(" ");
            int x1 = Integer.parseInt(sp[0]);
            int y1 = Integer.parseInt(sp[1]);
            int x2 = Integer.parseInt(sp[2]);
            int y2 = Integer.parseInt(sp[3]);

            int sum = 0;
            for (int j = x1; j <= x2 ; j++) {
                sum += arr[j][y2] - arr[j][y1-1];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}

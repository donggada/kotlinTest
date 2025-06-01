package com.example.kotlinTest.백준.백준_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n+1];
        String[] sp = br.readLine().split(" ");
        for (int i = 1; i <= n ; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(sp[i-1]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m ; i++) {
            String[] st = br.readLine().split(" ");
            int start = Integer.parseInt(st[0]);
            int end = Integer.parseInt(st[1]);
            sb.append(arr[end] - arr[start - 1]).append("\n");
        }

        System.out.println(sb);
    }


}

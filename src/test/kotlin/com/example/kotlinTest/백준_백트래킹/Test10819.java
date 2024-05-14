package com.example.kotlinTest.백준_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test10819 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int totalSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];

        String[] split = br.readLine().split(" ");


        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }


        totalSum = 0;

        for (int i = 0; i < N ; i++) {
            visited[i] = true;
            dfs(1, arr[i], 0);
            visited[i] = false;
        }

        System.out.println(totalSum);
    }

    private static void dfs(int depth, int num, int sum) {
        if (depth == N) {
            totalSum = Math.max(sum, totalSum);
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, arr[i], sum + Math.abs(num - arr[i]));
                visited[i] = false;
            }
        }
    }
}

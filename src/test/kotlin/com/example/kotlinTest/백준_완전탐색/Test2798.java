package com.example.kotlinTest.백준_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2798 {
    static int N;
    static int M;
    static int maxNum;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        maxNum = 0;
        arr = new int[N];
        visited = new boolean[N];

        String[] strings = br.readLine().split(" ");

        for (int i = 0; i < strings.length ; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        dfs(0, 0);

        System.out.println(maxNum);

    }

    private static void dfs(int depth, int sum) {
        if (depth == 3) {
            if (sum <= M) {
                maxNum = Math.max(maxNum, sum);
            }
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+ 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}

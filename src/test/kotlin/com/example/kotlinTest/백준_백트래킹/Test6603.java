package com.example.kotlinTest.백준_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6603 {
    static int[] arr;
    static boolean[] visited;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        K = Integer.parseInt(s[0]);

        while (K != 0) {
            arr = new int[K];
            visited = new boolean[K];
            for (int i = 1; i <= K ; i++) {
                arr[i-1] = Integer.parseInt(s[i]);
            }

            backTracking(0,0, "");

            System.out.println();
            s = br.readLine().split(" ");
            K = Integer.parseInt(s[0]);
        }
    }

    private static void backTracking(int start, int depth, String result) {
        if (depth == 6) {
            System.out.println(result);
            return;
        }

        for (int i = start; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(i,depth + 1, result + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}

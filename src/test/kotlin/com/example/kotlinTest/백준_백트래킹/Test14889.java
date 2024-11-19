package com.example.kotlinTest.백준_백트래킹;

import java.io.IOException;
import java.util.Scanner;

public class Test14889 {
    static int[][] arr;
    static boolean[] visited;
    static int sum = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        dfs(0,0);

        System.out.println(sum);

    }
    private static void dfs(int depth, int count) {
        if (count * 2 == N) {
            cal();
            return;
        }

        for (int i = depth; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1,count+1);
                visited[i] = false;
            }
        }
    }

    private static void cal() {
        int starTotal = 0;
        int linkTotal = 0;

        for (int i = 0; i < N ; i++) {
            for (int j = i+1; j < N ; j++) {
                if (visited[i] && visited[j]) {
                    starTotal += arr[i][j] + arr[j][i];
                    continue;
                }

                if (!visited[i] && !visited[j]) {
                    linkTotal += arr[i][j] + arr[j][i];
                }
            }
        }

        sum = Math.min(sum, Math.abs(starTotal - linkTotal));
    }
}

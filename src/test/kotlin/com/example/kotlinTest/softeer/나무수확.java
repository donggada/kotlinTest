package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나무수확 {
    static int[][] arr;
    static int n;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n ; j++) {
                arr[i][j] = Integer.valueOf(s[j]);
            }
        }

        dfs(0,0, 2 * arr[0][0], false);
        dfs(0,0, arr[0][0], true);
        System.out.println(result);

    }
    private static void dfs (int x, int y, int sum, boolean flag) {
        if (n - 1 == x && n - 1 == y) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 2 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < n && ny < n) {
                if (flag) {
                    dfs(nx, ny, sum + 2 * arr[nx][ny], false);
                } else  {
                    dfs(nx, ny, sum + arr[nx][ny], true);
                }
            }
        }


    }
}

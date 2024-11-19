package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test1520 {
        //  DFS + DP 활용  DP -> 경우에서수
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < N ; j++) {
                dp[i][j] = -1;
            }
        }
        int dfs = dfs(0, 0);
        System.out.println(dfs);
    }

    private static int dfs(int x, int y) {
        if (x == map.length -1 && y == map[0].length -1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > -1 && ny > -1 && nx < map.length && ny < map[0].length) {
                if (map[x][y] > map[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }
}

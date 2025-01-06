package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14503 {
    static int n;
    static int m;
    static int[][] arr;

    static int[] dx = {-1 ,0 ,1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static int cleanCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] init = br.readLine().split(" ");
        String[] info = br.readLine().split(" ");

        n = Integer.parseInt(init[0]);
        m = Integer.parseInt(init[1]);

        arr = new int[n][m];

        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
        System.out.println(cleanCount);
    }

    private static void dfs(int x, int y, int dir) {
        if (arr[x][y] == 0) {
            arr[x][y] = 2;
            cleanCount++;
        }

        for (int i = 0; i < 4 ; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx > -1 && nx < n && ny > -1 && ny < m) {
                if (arr[nx][ny] == 0) {
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4;
        int bx = x + dx[d];
        int by = y + dy[d];

        if (bx > -1 && bx < n && by >-1 && by < m) {
            if (arr[bx][by] != 1) {
                dfs(bx, by, dir);
            }
        }
    }


}

package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main14502 {
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static LinkedList<int[]> virusQueue;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];
        virusQueue = new LinkedList<>();

        for (int i = 0; i < n ; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < m ; j++) {
                int val = Integer.parseInt(lines[j]);
                arr[i][j] = val;
                if (val == 2) {
                    virusQueue.add(new int[]{i,j});
                }
            }
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallCount + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>(virusQueue);

        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int j = 0; j < 4 ; j++) {
                int nx = pop[0] + dx[j];
                int ny = pop[1] + dy[j];

                if (nx > -1 && nx < n && ny > -1 && ny < m) {
                    if (!visited[nx][ny] && arr[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        max = Math.max(findSafeZone(visited), max);
    }

    private static int findSafeZone(boolean[][] visited) {
        int count = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}

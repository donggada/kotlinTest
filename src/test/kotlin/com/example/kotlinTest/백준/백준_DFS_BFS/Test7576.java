package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test7576 {
    static int M;
    static int N;

    static boolean[][] visited;
    static int[][] map;

    static int count;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);

        visited = new boolean[N][M];
        map = new int[N][M];
        count = 1;
        boolean isSuccess = true;

        ArrayList<int[]> startList = new ArrayList<>();


        for (int i = 0; i < N ; i++) {
            String[] arr = br.readLine().split(" ");

            for (int j = 0; j < arr.length ; j++) {
                int n = Integer.parseInt(arr[j]);

                if (n == 1) {
                    startList.add(new int[]{i, j});
                }

                map[i][j] = n;
            }
        }

        bfs(startList);

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < M ; j++) {
                if (map[i][j] == 0) {
                    isSuccess = false;
                    break;
                }
            }
        }

        if (isSuccess) {
            System.out.println(count -1);
        }

        if (!isSuccess) {
            System.out.println(-1);
        }
    }

    private static void bfs(List<int[]> moveList) {
        LinkedList<int[]> queue = new LinkedList<>();

        for (int[] move : moveList) {
            int x = move[0];
            int y = move[1];

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            queue.add(move);
        }

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            int xx = pop[0];
            int yy = pop[1];

            for (int i = 0; i < 4 ; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (nx > -1 && ny > -1 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = map[xx][yy] + 1;
                        count = Math.max(map[nx][ny], count);
                    }
                }
            }
        }

    }
}

package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test2178 {

    static int N;
    static int M;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < arr.length ; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        bfs(new int[]{0,0});

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int[] move) {
        if (visited[move[0]][move[1]]) {
            return;
        }

        visited[move[0]][move[1]] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(move);

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            for (int i = 0; i < 4 ; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 && nx < N  && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] += map[pop[0]][pop[1]];
                    }
                }
            }

        }

    }
}

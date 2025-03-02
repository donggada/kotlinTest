package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test1012 {

    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0,0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());


        for (int i = 0; i < caseCount ; i++) {
            String[] initArray = br.readLine().split(" ");
            int M = Integer.parseInt(initArray[0]);
            int N = Integer.parseInt(initArray[1]);
            int K = Integer.parseInt(initArray[2]);

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int count = 0;

            for (int j = 0; j < K; j++) {
                String[] nodeArray = br.readLine().split(" ");
                int node1 = Integer.parseInt(nodeArray[0]);
                int node2 = Integer.parseInt(nodeArray[1]);

                map[node2][node1] = 1;
            }

            for (int j = 0; j < N ; j++) {
                for (int k = 0; k < M ; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        count++;
//                        dfs(new int[]{j, k}, map, visited);
                        bfs(new int[]{j, k}, map, visited);
                    }
                }
            }

            System.out.println(count);

        }
    }

    private static void dfs(int[] move, int[][] map, boolean[][] visited) {
        visited[move[0]][move[1]] = true;

        for (int i = 0; i < 4; i++) {
            int nx = move[0] + dx[i];
            int ny = move[1] + dy[i];

            if (nx > -1 && ny > -1 && nx < map.length && ny < map[0].length) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(new int[]{nx, ny}, map, visited);
                }
            }
        }
    }

    private static void bfs(int[] move, int[][] map, boolean[][] visited) {
        visited[move[0]][move[1]] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(move);
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 4; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 && nx < map.length && ny < map[0].length) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }



    }
}

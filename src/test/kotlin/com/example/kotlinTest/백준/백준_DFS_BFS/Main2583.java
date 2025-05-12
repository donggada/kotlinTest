package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main2583 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        int k = Integer.parseInt(sp[2]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k ; i++) {
            String[] info = br.readLine().split(" ");
            int x1 = Integer.parseInt(info[0]);
            int y1 = Integer.parseInt(info[1]);
            int x2 = Integer.parseInt(info[2]);
            int y2 = Integer.parseInt(info[3]);

            for (int j = y1; j < y2 ; j++) {
                for (int l = x1; l < x2 ; l++) {
                    arr[j][l] = 1;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    result.add(bfs(new int[]{i, j, 1}));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int n : result) {
            System.out.print(n + " ");

        }
    }

    private static int bfs(int[] move) {
        LinkedList<int[]> queue = new LinkedList<>();
        int count = 1;
        visited[move[0]][move[1]] = true;
        queue.add(move);

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 4; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < m) {
                    if (!visited[nx][ny] && arr[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }

            }
        }

        return count;
    }

}

package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Test2468 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        HashSet<Integer> set = new HashSet<>();


        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(s[j]);
                map[i][j] = n;
                set.add(n);
            }
        }

        int result = 0;

        if (set.size() == 1) {
            System.out.println(1);
            return;
        }

        for (int m :set) {
            int count = 0;
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] > m) {
                        bfs(new int[]{i, j}, m);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
            visited = new boolean[N][N];
        }

        System.out.println(result);

    }

    private static void bfs (int[] move, int min) {
        int x = move[0];
        int y = move[1];
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(move);

        while (!queue.isEmpty()){
            int[] pop = queue.pop();

            for (int i = 0; i < 4 ; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 &&  nx < map.length && ny < map[0].length) {
                    if (!visited[nx][ny] && map[nx][ny] > min) {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

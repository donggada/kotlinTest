package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main1743 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        boolean[][] map = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < k ; i++) {
            String[] sp = br.readLine().split(" ");
            map[Integer.parseInt(sp[0])-1][Integer.parseInt(sp[1])-1] = true;
        }

        int result = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (map[i][j] && !visited[i][j]) {
                    result = Math.max(result , bfs(new int[]{i,j}, map, visited));
                }
            }
        }

        System.out.println(result);
    }

    static private int bfs(int[] move, boolean[][] map, boolean[][] visited) {
        LinkedList<int[]> queue = new LinkedList<>();
        int count = 1;
        visited[move[0]][move[1]] = true;
        queue.add(move);

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 4 ; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];


                if(nx > -1 && nx < map.length && ny > -1 && ny < map[0].length) {
                    if (!visited[nx][ny] && map[nx][ny]) {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

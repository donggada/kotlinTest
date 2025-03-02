package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main16197 {
    static int[] dx = {1, 0,-1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;
    static char[][] arr;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        visited = new boolean[n][m][n][m];
        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < arr.length ; i++) {
            String sp = br.readLine();
            for (int j = 0; j <arr[i].length ; j++) {
                char val = sp.charAt(j);
                arr[i][j] = val;
                if (val == 'o') {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int[] poll1 = queue.poll();
        int[] poll2 = queue.poll();

        queue.add(new int[]{poll1[0], poll1[1], poll2[0], poll2[1], 1});
        visited[poll1[0]][poll1[1]][poll2[0]][poll2[1]] = true;
        System.out.println(bfs(queue));
    }

    private static int bfs(LinkedList<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[4] > 10) {
                return -1;
            }

            for (int i = 0; i < 4 ; i++) {
                int nx1 = poll[0] + dx[i];
                int ny1 = poll[1] + dy[i];
                int nx2 = poll[2] + dx[i];
                int ny2 = poll[3] + dy[i];

                if (check(nx1, ny1)) {
                    if (arr[nx1][ny1] == '#') {
                        nx1 = poll[0];
                        ny1 = poll[1];
                    }
                }

                if (check(nx2, ny2)) {
                    if (arr[nx2][ny2] == '#') {
                        nx2 = poll[2];
                        ny2 = poll[3];
                    }
                }

                int outCount = 0;

                if (!check(nx1, ny1)) {
                    outCount++;
                }

                if (!check(nx2, ny2)) {
                    outCount++;
                }


                if (outCount == 1) {
                    return poll[4];
                }

                if (outCount == 0) {
                    if (!visited[nx1][ny1][nx2][ny2]) {
                        queue.add(new int[]{nx1, ny1, nx2, ny2, poll[4]+1});
                    }
                }
            }
        }

        return -1;
    }

    private static boolean check (int x, int y) {
        return x> -1 && x < n && y > -1 && y < m;
    }
}

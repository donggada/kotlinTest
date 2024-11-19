package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test10026 {

    static String[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = s[j];
            }
        }

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    bfs1(new int[]{i,j}, map[i][j]);
                    count1++;
                }

                if (!visited2[i][j]) {
                    bfs2(new int[]{i,j}, map[i][j]);
                    count2++;
                }
            }
        }


        System.out.println(count1 + " " + count2);
    }

    private static void bfs1(int[] move, String color) {
        int x = move[0];
        int y = move[1];

        if (visited1[x][y]) {
            return;
        }

        visited1[x][y] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(move);
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 4 ; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 && nx < N && ny < N) {
                    if (!visited1[nx][ny] && map[nx][ny].equals(color)) {
                        queue.add(new int[]{nx, ny});
                        visited1[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void bfs2(int[] move, String color) {
        int x = move[0];
        int y = move[1];

        if (visited2[x][y]) {
            return;
        }

        visited2[x][y] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(move);
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 4 ; i++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 && nx < N && ny < N) {
                    if (!visited2[nx][ny] && (map[nx][ny].equals(color) || isRegGreen(map[nx][ny], color))) {
                        queue.add(new int[]{nx, ny});
                        visited2[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static boolean isRegGreen(String color1, String color2) {
        if (color1.equals("R") && color2.equals("G")) {
            return true;
        }

        if (color1.equals("G") && color2.equals("R")) {
            return  true;
        }

        return false;
    }
}

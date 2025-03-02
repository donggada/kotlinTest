package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main3055 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int r;
    static int c;
    static char[][] map;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        map = new char[r][c];
        visited = new boolean[r][c];

        int[] start = {};
        int[] end = {};
        LinkedList<int[]> water = new LinkedList<>();

        for (int i = 0; i < r ; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length ; j++) {
                char ch = charArray[j];

                if (ch == 'D') {
                    end = new int[]{i, j};
                }

                if (ch == 'S') {
                    start = new int[]{i, j, 0};
                }
                if (ch == '*') {
                    water.add(new int[]{i,j});
                }

                map[i][j] = ch;
            }
        }
        System.out.println(dfs(start, end, water));
    }

    private static String dfs (int[] start, int[] end, LinkedList<int[]> water) {
        visited[start[0]][start[1]] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int waterSize = water.size();

            for (int i = 0; i < waterSize ; i++) {
                int[] pop = water.pop();
                for (int j = 0; j < 4 ; j++) {
                    int nx = pop[0] + dx[j];
                    int ny = pop[1] + dy[j];

                    if (nx > -1 && nx < r && ny > -1 && ny < c) {
                        if (map[nx][ny] == '.' ) {
                            map[nx][ny] = '*';
                            water.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            int size = queue.size();

            for (int i = 0; i < size ; i++) {
                int[] pop = queue.pop();

                if (pop[0] == end[0] && pop[1] == end[1]) {
                    return String.valueOf(pop[2]);
                }

                for (int j = 0; j < 4 ; j++) {
                    int nx = pop[0] + dx[j];
                    int ny = pop[1] + dy[j];

                    if (nx > -1 && nx < r && ny > -1 && ny < c) {
                        if (!visited[nx][ny] && (map[nx][ny] == '.'|| map[nx][ny] == 'D')) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, pop[2] + 1});
                        }
                    }
                }
            }

        }
        return "KAKTUS";
    }
}

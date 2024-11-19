package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 나무섭지 {
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Integer n = Integer.valueOf(s[0]);
        Integer m = Integer.valueOf(s[1]);

        arr = new String[n][m];
        visited = new boolean[n][m];
        int[] start = {};
        int[] end = {};
        List<int[]> ghostList = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            String[] sp = br.readLine().split("");
            for (int j = 0; j < m ; j++) {
                String val = sp[j];
                if (val.equals("N")) {
                    start = new int[] {i, j};
                }

                if (val.equals("D")) {
                    end = new int[] {i, j};
                }

                if (val.equals("G")) {
                    ghostList.add(new int[] {i, j});
                }

                arr[i][j] = val;
            }
        }



        bfs(start, ghostList);


        System.out.println(visited[end[0]][end[1]] ? "Yes" : "No");
    }

    private static void bfs(int[] move, List<int[]> ghostList) {
        int x = move[0];
        int y = move[1];

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > -1 && ny > -1 && nx < arr.length & ny < arr[0].length) {
                if (!visited[nx][ny] && !arr[nx][ny].equals("#")) {
                    bfs(new int[]{nx, ny}, ghostList);
                    visited[nx][ny] = true;
                }
            }
        }

    }

    private static boolean check (List<int[]> ghostList) {
        return false;
    }

}

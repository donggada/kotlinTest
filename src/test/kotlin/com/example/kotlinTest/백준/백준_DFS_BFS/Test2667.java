package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Test2667 {
    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> countList;
    static int count;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new int[n][n];
        countList = new ArrayList<>();
        count = 0;

        for (int i = 0; i < n ; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < arr.length ; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int x = 0; x <map.length ; x++) {
            for (int y = 0; y <map.length ; y++) {
                //DFS
                if (map[x][y] == 1 && !visited[x][y]) {
                    dfs(new int[]{x, y});
                    countList.add(count);
                    count = 0;
                }

                //bFS
//                if (map[x][y] == 1 ) {
//                    bfs(new int[]{x, y});
//                }
            }
        }

        System.out.println(countList.size());
        Collections.sort(countList);
        for (Integer i : countList) {
            System.out.println(i);
        }

    }

    private static void dfs(int[] moveArray) {
        count++;
        int x = moveArray[0];
        int y = moveArray[1];

        visited[x][y] = true;

        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > -1  && ny > -1 && nx < map.length && ny < map.length) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(new int[]{nx, ny});
                }
            }
        }

    }

    private static void bfs(int[] moveArray) {
        if (visited[moveArray[0]][moveArray[1]]) {
            return;
        }

        visited[moveArray[0]][moveArray[1]] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(moveArray);

        int mapCount = 1;

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            int xx = pop[0];
            int yy = pop[1];

            for (int i = 0; i < 4 ; i++) {
                int nx = xx + dx[i];
                int ny= yy + dy[i];

                if (nx > -1  && ny > -1 && nx < map.length && ny < map.length) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        mapCount++;
                    }
                }
            }
        }
        countList.add(mapCount);
    }


}

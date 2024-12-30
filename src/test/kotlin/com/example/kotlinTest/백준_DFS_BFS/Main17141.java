package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main17141 {
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[] virusVisit;
    static List<int[]> virusList;
    static List<int[]> stack = new ArrayList<>();
    static int time = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][n];
        virusList = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 0; j < n ; j++) {
                int val = Integer.parseInt(lines[j]);
                arr[i][j] = val;
                if (val == 2) {
                    virusList.add(new int[]{i,j});
                }
            }
        }

        virusVisit = new boolean[virusList.size()];
        dfs(0, 0);
        System.out.println(time == Integer.MAX_VALUE ? -1: time);
    }

    private static void dfs(int virusCount, int idx) {
        if (virusCount == m) {
            bfs();
            return;
        }

        for (int i = idx; i < virusList.size() ; i++) {
            if (!virusVisit[i]) {
                virusVisit[i] = true;
                stack.add(virusList.get(i));
                dfs(virusCount + 1,idx + 1);
                virusVisit[i] = false;
                stack.remove(stack.size()-1);
            }
        }
    }

    private static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>();
        int maxTime = 0;
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n ; i++) {
            map[i] = arr[i].clone();
        }

        for (int i = 0; i < m ; i++) {
            int[] v = stack.get(i);
            visited[v[0]][v[1]] = true;
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int j = 0; j < 4 ; j++) {
                int nx = pop[0] + dx[j];
                int ny = pop[1] + dy[j];

                if (nx > -1 && nx < n && ny > -1 && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] != 1) {
                        int val = pop[2] + 1;
                        queue.add(new int[]{nx, ny, val});
                        maxTime = Math.max(val, maxTime);
                        visited[nx][ny] = true;
                        map[nx][ny] = 2;
                    }
                }
            }

        }

        if (isAllVirus(map,visited)) {
            time = Math.min(time, maxTime);
        }
    }

    private static boolean isAllVirus(int[][] map, boolean[][] visited) {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if (!visited[i][j] && map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

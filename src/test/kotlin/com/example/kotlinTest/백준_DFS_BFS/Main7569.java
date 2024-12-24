package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main7569 {
    static int[][][] box;
    static int n;
    static int m;
    static int h;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);

        box = new int[h][n][m];

        LinkedList<int[]> queue = new LinkedList<>();

        for (int z = 0; z < h ; z++) {
            for (int x = 0; x < n ; x++) {
                String[] sp = br.readLine().split(" ");
                for (int y = 0; y < m ; y++) {
                    int val = Integer.parseInt(sp[y]);
                    box[z][x][y] = val;
                    if (val == 1) {
                        queue.add(new int[]{z, x, y});
                    }
                }
            }
        }

        dfs(queue);

        System.out.println(result());

    }

    private static void dfs(LinkedList<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 6 ; i++) {
                int nx = pop[1] + dx[i];
                int ny = pop[2] + dy[i];
                int nz = pop[0] + dz[i];


                if (nx > -1 && nx < n && ny > -1 && ny < m &&  nz > -1 && nz < h) {
                    if (box[nz][nx][ny] == 0) {
                        queue.add(new int[]{nz, nx, ny});
                        box[nz][nx][ny] = box[pop[0]][pop[1]][pop[2]] + 1;
                    }
                }

            }
        }

    }

    private static int result () {
        int result = 0;

        for (int i = 0; i <h ; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }

                    result = Math.max(result, box[i][j][k]);
                }
            }
        }

        return result -1;
    }
}

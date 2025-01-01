package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main14503 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1 ,0 ,1 ,0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] init = br.readLine().split(" ");
        String[] info = br.readLine().split(" ");

        n = Integer.parseInt(init[0]);
        m = Integer.parseInt(init[0]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2])});

        System.out.println(bfs(queue));
    }

    private static int bfs(LinkedList<int[]> queue) {
        int moveCount = 0;


        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            int nx = pop[0] + dx[pop[2]];
            int ny = pop[1] + dy[pop[2]];
            

            moveCount++;
        }

        return moveCount;
    }


}

package com.example.kotlinTest.백준.백준_백트래킹;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Test1987 {
    static String[][] arr;
    static boolean[][] visited;

    static int R;
    static int C;
    static int maxCount;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);


        arr = new String[R][C];
        visited = new boolean[R][C];
        maxCount = 0;

        for (int i = 0; i < R ; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C ; j++) {
                arr[i][j] = str[j];
            }
        }

//        bfs(new int[]{0,0});
        HashSet<String> start = new HashSet<>();
        start.add(arr[0][0]);
        dfs(new int[]{0, 0, 1}, start);


        System.out.println(maxCount);

    }

    private static void dfs(int[] move, HashSet<String> set) {
        for (int i = 0; i < 4 ; i++) {
            int nx = move[0] + dx[i];
            int ny = move[1] + dy[i];

            if (nx > -1 && ny > -1 && nx < R  && ny < C) {
                if (!set.contains(arr[nx][ny])) {
                    HashSet<String> newSet = new HashSet<>(set);
                    newSet.add(arr[nx][ny]);
                    dfs(new int[]{nx, ny, move[2] + 1}, newSet);
                }
            }
        }

        maxCount = Math.max(maxCount, move[2]);
    }

}

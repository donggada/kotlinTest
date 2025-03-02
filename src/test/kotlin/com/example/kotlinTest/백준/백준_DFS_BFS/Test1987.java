package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Test1987 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] map;
    static int[][] board;
    static int maxMove;
    static boolean[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int R = Integer.parseInt(arr[0]);
        int C = Integer.parseInt(arr[1]);

        map = new String[R][C];
        board = new int[R][C];
        alpha = new boolean[26];

        for (int i = 0; i < R ; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < split.length ; j++) {
                map[i][j] = split[j];
            }
            char[] charArray = s.toCharArray();

            for (int j = 0; j < charArray.length  ; j++) {
                board[i][j] = charArray[j] - 'A';
            }
        }

        dfs(0,0,1);
//        dfs(new Node(0, 0, new HashSet<>()));
        System.out.println(maxMove);

    }

    private static void dfs(int x, int y, int len) {
        alpha[board[x][y]] = true;
        maxMove = Math.max(maxMove, len);

        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > -1 && ny > -1 && nx < map.length && ny < map[0].length) {
                if (!alpha[board[nx][ny]]) {
                    dfs(nx, ny, len + 1);
                    alpha[board[nx][ny]] = false;
                }
            }
        }
    }

    // 공간 및 시간 초과로 실패
//    private static void dfs(Node node) {
//        HashSet<String> visited = node.visited;
//        visited.add(map[node.x][node.y]);
//        maxMove = Math.max(maxMove, visited.size());
//
//        for (int i = 0; i < 4 ; i++) {
//            int nx = node.x + dx[i];
//            int ny = node.y + dy[i];
//
//            if (nx > -1 && ny > -1 && nx < map.length && ny < map[0].length) {
//                if (!visited.contains(map[nx][ny])) {
//                    HashSet<String> newVisited = new HashSet<>(visited);
//                    newVisited.add(map[nx][ny]);
//                    dfs(new Node(nx, ny, newVisited));
//                }
//            }
//        }
//    }

//    static class Node {
//        int x;
//        int y;
//        HashSet<String> visited;
//
//        public Node(int x, int y, HashSet<String> visited) {
//            this.x = x;
//            this.y = y;
//            this.visited = visited;
//        }
//    }
}

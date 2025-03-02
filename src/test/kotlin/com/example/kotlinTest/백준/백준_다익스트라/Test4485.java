package com.example.kotlinTest.백준.백준_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test4485 {
    static int[][] arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int index = 1;
        while (N != 0) {
            arr = new int[N][N];

            for (int i = 0; i < N ; i++) {
                String[] split = br.readLine().split(" ");
                for (int j = 0; j < split.length; j++) {
                    arr[i][j] = Integer.parseInt(split[j]);
                }
            }



            System.out.println("Problem "+ index + ": "+ dijkstra(N));
            index++;

            N = Integer.parseInt(br.readLine());
        }
    }

    private static int dijkstra(int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0 ,0, arr[0][0]));


        int[][] move = new int[n][n];

        for (int i = 0; i < n ; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }
        move[0][0] = arr[0][0];

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.x == n-1 && poll.y == n-1) {
                return move[n-1][n-1];
            }

            for (int i = 0; i < 4 ; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx > -1 && ny > -1 && ny < n && nx < n) {
                    int val = poll.val + arr[nx][ny];
                    if (val < move[nx][ny]) {
                        move[nx][ny] = val;
                        queue.add(new Node(nx, ny, val));
                    }

                }
            }
        }
        return -1;
    }

    private static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int val;
        @Override
        public int compareTo(Node node) {
            return this.val - node.val;
        }

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}

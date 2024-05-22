package com.example.kotlinTest.백준_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test1916 {
    static int[] result;
    static boolean[] visited;
    static List<Node>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        result = new int[N+1];
        visited = new boolean[N+1];
        nodes = new List[N+1];

        for (int i = 0; i < N + 1  ; i++) {
            result[i] = Integer.MAX_VALUE;
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M ; i++) {
            String[] split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int val = Integer.parseInt(split[2]);
            nodes[from].add(new Node(to, val));
        }

        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        dijkstra(start);

        System.out.println(result[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        result[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            visited[cur.end] = true;

            if (result[cur.end] < cur.val) {
                continue;
            }

            for (Node node: nodes[cur.end]) {
                if (!visited[node.end]) {
                    int val = node.val + result[cur.end];
                    if (val < result[node.end]) {
                        result[node.end] = val;
                        queue.add(new Node(node.end, val));
                    }
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

        public int end;
        public int val;
        @Override
        public int compareTo(Node node) {
            return this.val - node.val;
        }

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }
}

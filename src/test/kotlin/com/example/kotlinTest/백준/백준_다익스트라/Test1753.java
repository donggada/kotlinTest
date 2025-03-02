package com.example.kotlinTest.백준.백준_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
public class Test1753 {

    static List<Node>[] nodes;
    static boolean[] check;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vAndE = br.readLine().split(" ");
        int v = Integer.parseInt(vAndE[0]);
        int e = Integer.parseInt(vAndE[1]);
        nodes = new ArrayList[v+1];
        check = new boolean[v+1];
        distance = new int[v+1];

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i <= v; i++){
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++){
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to, value));
        }

        dij(start);

        for (int i = 1; i <= v; i++){

            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }

            System.out.println(distance[i]);
        }

    }

    public static void dij(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[start] = 0;
        q.offer(new Node(start,0));

        while (!q.isEmpty()){
            Node cur = q.poll();
            check[cur.end] = true;
            for(Node node : nodes[cur.end]){
                if (!check[node.end]){
                    if (distance[cur.end] + node.cost < distance[node.end]){
                        distance[node.end] = distance[cur.end] + node.cost;
                        q.offer(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
    }


    static class Node implements Comparable<Node>{
        public int end;
        public int cost;

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;}
    }

}

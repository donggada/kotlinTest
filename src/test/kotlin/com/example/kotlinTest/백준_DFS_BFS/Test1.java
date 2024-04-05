package com.example.kotlinTest.백준_DFS_BFS;

import java.util.*;
public class Test1 {
    // DFS 와 BFS
    // https://www.acmicpc.net/problem/1260 DFS dhk
    static HashSet<Integer> visited;
    static HashMap<Integer, List<Integer>> nodeMap;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();
        visited = new HashSet<>();
        nodeMap = new HashMap<>();

        for (int i = 0; i < M ; i++) {
            int startNode = scanner.nextInt();
            int endNode = scanner.nextInt();

            List<Integer> startNodeList = nodeMap.getOrDefault(startNode, new ArrayList<>());
            startNodeList.add(endNode);
            Collections.sort(startNodeList);

            List<Integer> endNodeList = nodeMap.getOrDefault(endNode, new ArrayList<>());
            endNodeList.add(startNode);
            Collections.sort(endNodeList);

            nodeMap.put(startNode, startNodeList);
            nodeMap.put(endNode, endNodeList);
        }

        //DFS -> BFS
        System.out.print(V + " ");
        dfs(V);

        visited.clear();
        System.out.println();
        System.out.print(V + " ");
        bfs(V);
    }

    private static void dfs(int startNode) {
        visited.add(startNode);
        List<Integer> nodeList = nodeMap.getOrDefault(startNode, new ArrayList<>());
        for (int n : nodeList) {
            if (!visited.contains(n)) {
                System.out.print(n + " ");
                dfs(n);
            }
        }
    }

    private static void bfs(int startNode) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited.add(startNode);

        while (!q.isEmpty()) {
            Integer node = q.pop();
            List<Integer> nodeList = nodeMap.getOrDefault(node, new ArrayList<>());

            for (int n : nodeList) {
                if (!visited.contains(n)) {
                    System.out.print(n + " ");
                    visited.add(n);
                    q.add(n);
                }
            }
        }
    }


}

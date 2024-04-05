package com.example.kotlinTest.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test11724 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        HashMap<String, List<String>> nodeMap = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < M ; i++) {
            String[] arr = br.readLine().split(" ");
            String startNode= arr[0];
            String endNode= arr[1];

            List<String> startNodeList = nodeMap.getOrDefault(startNode, new ArrayList<>());
            List<String> endNodeList = nodeMap.getOrDefault(endNode, new ArrayList<>());

            startNodeList.add(endNode);
            endNodeList.add(startNode);

            nodeMap.put(startNode, startNodeList);
            nodeMap.put(endNode, endNodeList);
        }
//        int count = 0;
        for (int i = 1; i <= N ; i++) {
            count += dfs(String.valueOf(i), nodeMap, visited);
//            bfs(String.valueOf(i), nodeMap, visited);
        }


        System.out.println(count);

    }

    private static int dfs(String node, HashMap<String, List<String>> nodeMap, HashSet<String> visited) {
        if (visited.contains(node)) {
            return 0;
        }

        visited.add(node);
        List<String> nodeList = nodeMap.getOrDefault(node, new ArrayList<>());

        for (String n : nodeList) {
            if (!visited.contains(n)) {
                bfs(n, nodeMap, visited);
                visited.add(n);
            }
        }

        return 1;
    }

    private static void bfs (String node, HashMap<String, List<String>> nodeMap, HashSet<String> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        LinkedList<String> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            String moveNode = queue.pop();

            List<String> nodeList = nodeMap.getOrDefault(moveNode, new ArrayList<>());

            for (String n : nodeList) {
                if (!visited.contains(n)) {
                    queue.add(n);
                    visited.add(n);
                }
            }

        }

        count++;
    }
}

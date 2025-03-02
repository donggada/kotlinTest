package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test2606 {
    static HashMap<Integer, List<Integer>> nodeMap;
    static HashSet<Integer> visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeMap = new HashMap<>();
        visited = new HashSet<>();

        int node = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n ; i++) {
            String[] arr = br.readLine().split(" ");
            int node1 = Integer.parseInt(arr[0]) -1;
            int node2 = Integer.parseInt(arr[1]) -1;

            List<Integer> nodeList1 = nodeMap.getOrDefault(node1, new ArrayList<>());
            List<Integer> nodeList2 = nodeMap.getOrDefault(node2, new ArrayList<>());

            nodeList1.add(node2);
            nodeList2.add(node1);

            nodeMap.put(node1, nodeList1);
            nodeMap.put(node2, nodeList2);
        }

        dfs(0);


        System.out.println(count);

    }

    private static void dfs(int node) {
        visited.add(node);

        List<Integer> nextNodeList = nodeMap.getOrDefault(node, new ArrayList<>());

        for (int nextNode : nextNodeList) {
            if (!visited.contains(nextNode)) {
                count++;
                dfs(nextNode);
            }
        }
    }
}

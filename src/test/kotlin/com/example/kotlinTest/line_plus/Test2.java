package com.example.kotlinTest.line_plus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Test2 {
    static HashMap<Integer, Integer> nodeMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodeMap = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodeMap.putIfAbsent(a,a);
            nodeMap.putIfAbsent(b,b);
            unionNode(a, b);
        }

        HashSet<Integer> set = new HashSet<>();

        for (Integer key :nodeMap.keySet()) {
            set.add(findParentNode(key));
        }

        System.out.println(set.size());
    }

    private static int findParentNode(int node) {
        if (nodeMap.get(node) == node) {
            return node;
        }
        int nextNode = findParentNode(nodeMap.get(node));
        nodeMap.put(node, nextNode);
        return nextNode;
    }

    private static void unionNode(int node1, int node2) {
        int startNodeParent = findParentNode(node1);
        int endNodeParent = findParentNode(node2);
        if (startNodeParent != endNodeParent) {
            nodeMap.put(endNodeParent, startNodeParent);
        }
    }
}

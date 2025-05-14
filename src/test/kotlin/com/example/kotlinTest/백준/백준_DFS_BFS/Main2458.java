package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2458 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<Integer, List<Integer>> forwardNode = new HashMap<>();
        Map<Integer, List<Integer>> reverseNode = new HashMap<>();
        int result = 0;

        for (int i = 0; i < m ; i++) {
            String[] sp = br.readLine().split(" ");
            int a = Integer.parseInt(sp[0]) - 1;
            int b = Integer.parseInt(sp[1]) - 1;
            List<Integer> forwardList = forwardNode.getOrDefault(a, new ArrayList<>());
            forwardList.add(b);
            forwardNode.put(a, forwardList);

            List<Integer> reverseList = reverseNode.getOrDefault(b, new ArrayList<>());
            reverseList.add(a);
            reverseNode.put(b, reverseList);
        }

        for (int i = 0; i < n ; i++) {
            int forwardCount = cal(new boolean[n], i, forwardNode);
            int reverseCount = cal(new boolean[n], i, reverseNode);

            if (forwardCount + reverseCount - 1 == n) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int cal(boolean[] newVisited, int i, Map<Integer, List<Integer>> forwardNode) {
        visited = newVisited;
        bfs(i, forwardNode);
        return count();
    }

    static private void bfs(int startNode, Map<Integer, List<Integer>> node) {
        visited[startNode] = true;
        List<Integer> nextNodes = node.getOrDefault(startNode, new ArrayList<>());

        for (int nextNode : nextNodes) {
            if (!visited[nextNode]) {
                bfs(nextNode, node);
            }
        }
    }

    static private int count() {
        int count = 0;
        for (boolean v : visited) {
            if (v) {
                count++;
            }
        }
        return count;
    }
}

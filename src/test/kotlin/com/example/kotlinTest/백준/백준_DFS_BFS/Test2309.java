package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2309 {

    static int[] arr;
    static boolean[] visited;

    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        visited = new boolean[9];
        result = new ArrayList<>();

        for (int i = 0; i < 9 ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0,0, new ArrayList<>());

        for (int n: result) {
            System.out.println(n);
        }
    }

    private static void dfs(int depth,int index, List<Integer> list) {
        if (depth == 7) {
            if (list.stream().mapToInt(n -> n).sum() == 100) {
                Collections.sort(list);
                if (result.isEmpty()) {
                    result = list;
                }
            }
            return;
        }

        for (int i = index; i < 9 ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(arr[i]);
                dfs(depth + 1, i, newList);
                visited[i] = false;
            }
        }
    }
}

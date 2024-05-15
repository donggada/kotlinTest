package com.example.kotlinTest.백준_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test6603 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            if (n == 0) {
                break;
            }

            visited = new boolean[n + 1];
            dfs(0, 1, Integer.parseInt(split[0]), split, new ArrayList<>());
            System.out.println();
        }

    }

    private static void dfs(int depth, int index, int maxSize,  String[] arr, List<String> list) {
        if (depth == 6) {
            System.out.println(String.join(" ",list));
            return;
        }

        for (int i = index; i < arr.length ; i++) {
            if (i == 0) {
                continue;
            }

            if(!visited[i]) {
                visited[i] = true;
                ArrayList<String> newList = new ArrayList<>(list);
                newList.add(arr[i]);
                dfs(depth + 1, i, maxSize, arr, newList);
                visited[i] = false;
            }
        }
    }
}

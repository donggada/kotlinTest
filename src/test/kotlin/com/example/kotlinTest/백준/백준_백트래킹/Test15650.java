package com.example.kotlinTest.백준.백준_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test15650 {
    static int N;
    static int M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        visited = new boolean[N];

        backTracking(0, new ArrayList<>());

    }

    private static void backTracking(int index, List<Integer> list){
        if (list.size() == M) {
            for (int n : list){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(i + 1);
                backTracking(index + 1, newList);
                visited[i] = false;
            }

        }
    }
}

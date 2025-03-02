package com.example.kotlinTest.백준.백준_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test15649 {
    static int N;
    static int M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        visited = new boolean[N];

        backTracking(new ArrayList<>());

    }

    private static void backTracking(List<Integer> list){
        if (list.size() == M) {

            for (int n : list){
                System.out.print(n + " ");

            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(i + 1);
                backTracking(newList);
                visited[i] = false;
            }

        }
    }
}

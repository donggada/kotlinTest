package com.example.kotlinTest.백준.백준_완전탐색;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test15652 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        dfs(0, 0, new ArrayList<>());
    }
    
    private static void dfs(int depth, int index, List<Integer> list) {
        if (depth == M) {
            for (int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < N ; i++) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(i + 1);
            dfs(depth + 1, i, newList);
        }
    }
}

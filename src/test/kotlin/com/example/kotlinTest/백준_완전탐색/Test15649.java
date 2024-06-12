package com.example.kotlinTest.백준_완전탐색;

import java.util.Scanner;

public class Test15649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();


        int [] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = i + 1;
        }

        bfs(0, m, arr, visited, "");

    }

    private static void bfs(int depth, int m, int[] arr, boolean[] visited, String input) {
        if (depth == m) {
            System.out.println(String.join(" ", input.split("")));
            return;
        }

        for (int i = 0; i < arr.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(depth + 1, m ,arr, visited, input + arr[i]);
                visited[i] = false;
            }
        }
    }
}

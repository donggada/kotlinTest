package com.example.kotlinTest.백준.백준_다익스트라;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test1179 {
    static boolean[] visited;
    static int[] result;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        visited = new boolean[N];
        result = new int[N];
        arr = new int[N][N];

        for (int i = 0; i < N ; i++) {
            arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start);

        System.out.println(result[end-1]);

    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        queue.add(new int[]{start, 0});
        result[start] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int end = poll[0];
            visited[end] = true;

            if (result[end] < poll[1]) {
                continue;
            }
            for (int i = 0; i < result.length ; i++) {
                if (arr[end][i] != 0 && !visited[i]) {
                    int val = result[end] + arr[end][i];
                    if (val < result[i]) {
                        result[i] = val;
                        queue.add(new int[]{i, val});
                    }
                }


            }
        }
    }

}

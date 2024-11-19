package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 택배마스터광우 {
    static boolean[] visited;
    static int[] arr;
    static Integer N;
    static Integer M;
    static Integer K;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.valueOf(s[0]);
        M = Integer.valueOf(s[1]);
        K = Integer.valueOf(s[2]);

        visited = new boolean[N];
        arr = new int[N];
        String[] sp = br.readLine().split(" ");

        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.valueOf(sp[i]);
        }
        dfs(0, new int[N]);

        System.out.println(result);
    }

    private static void dfs(int depth, int[] array) {
        if (depth == N) {
            result = Math.min(result, cal(array));
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = arr[i];
                dfs(depth + 1, array);
                visited[i] = false;
            }
        }
    }

    private static int cal (int[] array) {
        int total = 0;
        int index = 0;
        for (int i = 0; i < K ; i++) {
            int wight = 0;
            while (wight + array[index] <= M) {
                wight += array[index];
                index++;
                index %= N;
            }
            total += wight;
        }
        return total;
    }

}

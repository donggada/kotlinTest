package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);
        for (int i = 1; i < n ; i++) {
            if (!queue.isEmpty() && queue.peek() <= arr[i][0]) {
                queue.poll();
            }

            queue.add(arr[i][1]);
        }

        System.out.println(queue.size());
    }
}

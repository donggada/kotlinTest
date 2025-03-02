package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test19598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i <N ; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);
        int count = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);

        for (int i = 1; i < N ; i++) {
            if (queue.peek() <= arr[i][0]) {
                queue.poll();
                queue.add(arr[i][1]);
                continue;
            }

            queue.add(arr[i][1]);
            count++;
        }

        System.out.println(count);
    }
}

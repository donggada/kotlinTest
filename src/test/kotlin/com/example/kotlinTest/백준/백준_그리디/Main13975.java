package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t ; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n ; j++) {
                queue.add(Long.parseLong(s[j]));
            }
            long max = 0;

            while (!queue.isEmpty()) {
                Long poll = queue.poll();
                if (!queue.isEmpty()) {
                    long sum = poll + queue.poll();
                    max += sum;
                    queue.add(sum);
                }
            }

            System.out.println(max);
        }
    }
}

package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int count = Integer.parseInt(s[1]);
        String[] sp = br.readLine().split(" ");
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < n ; i++) {
            queue.add(Long.parseLong(sp[i]));
        }

        for (int i = 0; i < count ; i++) {
            long val = queue.poll() + queue.poll();
            queue.add(val);
            queue.add(val);
        }

        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        System.out.println(sum);
    }
}

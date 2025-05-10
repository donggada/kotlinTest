package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long index = 1;
        long result = 0;

        while (!queue.isEmpty()) {
            result += Math.abs(queue.poll() - index);
            index++;
        }

        System.out.println(result);
    }
}

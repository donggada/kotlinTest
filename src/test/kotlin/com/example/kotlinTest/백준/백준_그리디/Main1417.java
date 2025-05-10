package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int daSam = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n-1 ; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (daSam <= poll) {
                count++;
                daSam++;
                queue.add(poll-1);
            }
        }

        System.out.println(count);
    }
}

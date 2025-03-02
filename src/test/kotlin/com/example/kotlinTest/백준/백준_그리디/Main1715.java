package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n ; i++) {
            queue.add(Integer.valueOf(br.readLine()));
        }

        int total = 0;

        while (queue.size() > 1) {
            int sum =  queue.poll() + queue.poll();
            total += sum;
            queue.add(sum);
        }

        System.out.println(total);
    }

    // array.sort 사용하면안되는이유 앞에카드 합이 더 적을수 있을
    // ex 10, 20, 25, 27, 40 이럴경우
    // ex 10 + 20 = 30  -> 30 ,25  합치게 되는데 최솟값이면 25, 27로 합쳐야 함
}

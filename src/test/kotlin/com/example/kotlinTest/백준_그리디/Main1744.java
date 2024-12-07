package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

        for (int i = 0; i < n ; i++) {
            Integer num = Integer.valueOf(br.readLine());

            if (num > 0)  {
               plusQueue.add(num);
               continue;
            }

            minusQueue.add(num);
        }
        
        System.out.println(calPlus(plusQueue) + calMinus(minusQueue));
    }

    private static int calPlus(PriorityQueue<Integer> queue) {
        int result = 0;
        while (!queue.isEmpty()) {
            Integer val = queue.poll();

            if (queue.isEmpty()) {
                result += val;
                break;
            }

            if(queue.peek() == 1) {
                result += val + queue.poll();
                continue;
            }

            result += queue.poll() * val;
        }
        return result;
    }

    private static int calMinus(PriorityQueue<Integer> queue) {
        int result = 0;
        while (!queue.isEmpty()) {
            Integer val = queue.poll();

            if (queue.isEmpty()) {
                result += val;
                break;
            }

            result += queue.poll() * val;

        }
        return result;
    }
}

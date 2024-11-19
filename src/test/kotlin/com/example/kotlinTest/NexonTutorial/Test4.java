package com.example.kotlinTest.NexonTutorial;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;
public class Test4 {

    @Test
    void case1() {
        Assertions.assertThat(Test4.findMinWeight(List.of(30, 20,25), 4)).isEqualTo(31);
    }

    @Test
    void case2() {
        Assertions.assertThat(Test4.findMinWeight(List.of(2), 1)).isEqualTo(1);
    }

    @Test
    void case3() {
        Assertions.assertThat(Test4.findMinWeight(List.of(2,3), 1)).isEqualTo(4);
    }

    public static int findMinWeight(List<Integer> weights, int d) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int weight : weights) {
            pq.offer(weight);
        }

        // d일 동안 반복
        for (int day = 0; day < d; day++) {
            int currentWeight = pq.poll();
            int remainingWeight;

            if (currentWeight % 2 == 0) {
                remainingWeight=  currentWeight / 2;
            } else {
                remainingWeight = (currentWeight / 2) + 1;
            }

            pq.offer(remainingWeight);
        }

        int totalWeight = 0;
        while (!pq.isEmpty()) {
            totalWeight += pq.poll();
        }

        return totalWeight;
    }
}

package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test4 {

    Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8})
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{2,2,2,2}, new int[]{1,1,1,1})
        ).isEqualTo(
                0
        );
    }

    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            PriorityQueue<Integer> queueA = new PriorityQueue<>();
            PriorityQueue<Integer> queueB = new PriorityQueue<>();
            for (int i = 0; i < A.length ; i++) {
                queueA.add(A[i]);
                queueB.add(B[i]);
            }

            while (!queueA.isEmpty() && !queueB.isEmpty()) {
                Integer valA = queueA.poll();

                if (valA < queueB.peek()) {
                    queueB.poll();
                    answer++;
                    continue;
                }

                queueA.add(valA);
                queueB.poll();
            }

            return answer;
        }
    }
}

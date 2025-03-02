package com.example.kotlinTest.프로그래머스.프로그래머스_스택_큐;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test4 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{2, 1, 3, 2}, 2)
        ).isEqualTo(
            1
        );

        Assertions.assertThat(
            solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0)
        ).isEqualTo(
            5
        );

    }


    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int num :priorities) {
                priorityQueue.add(num);
            }

            while (!priorityQueue.isEmpty()) {
                for (int i = 0; i < priorities.length ; i++) {
                    if (priorities[i] == priorityQueue.peek() ) {
                        priorityQueue.poll();
                        answer++;
                        if (i == location) {
                            return answer;
                        }
                    }
                }
            }
            return answer;
        }
    }

}

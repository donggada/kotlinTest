package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(4, new int[]{4,3,3})
        ).isEqualTo(12);
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(1, new int[]{2,1,2})
        ).isEqualTo(6);
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(3, new int[]{1,1})
        ).isEqualTo(0);
    }

    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int w : works) {
                queue.add(w);
            }

            for (int i = 0; i < n ; i++) {
                if (queue.isEmpty()) {
                    break;
                }

                Integer work = queue.poll();
                if (work == 0) {
                    break;
                }

                queue.add(work-1);
            }

            while (!queue.isEmpty()) {
                Integer w = queue.poll();
                answer += (long) w * w;
            }

            return answer;
        }
    }
}

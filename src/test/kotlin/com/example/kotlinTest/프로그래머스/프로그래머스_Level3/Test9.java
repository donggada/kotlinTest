package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test9 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(6, new int[]{7, 10})
        ).isEqualTo(
                28
        );
    }

    class Solution {

        public long solution(int n, int[] times) {
            long answer = Long.MAX_VALUE;
            int len = times.length;
            Arrays.sort(times);

            long start = times[0];
            long end = (long) times[len - 1] * n;
            long mid = 0;
            long count = 0;
            while (start <= end) {
                count = 0;
                mid = (start + end) / 2;

                for (int t: times) {
                    count += mid/t;
                }

                if (count >= n) {
                    answer = Math.min(answer, mid);
                    end = mid -1;
                    continue;
                }

                start = mid +1;

            }

            return answer;
        }
    }
}

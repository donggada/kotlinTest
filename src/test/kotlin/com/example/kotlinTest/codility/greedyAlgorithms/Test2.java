package com.example.kotlinTest.codility.greedyAlgorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {
    private final Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(solution.solution(4, new int[]{1, 2, 3, 4, 1, 1, 3})).isEqualTo(3);
    }

    static class Solution {
        public int solution(int K, int[] A) {
            int count = 0;
            int len = 0;

            for (int a : A) {
                len += a;
                if (len >= K) {
                    count++;
                    len = 0;
                }
            }

            return count;
        }

    }
}


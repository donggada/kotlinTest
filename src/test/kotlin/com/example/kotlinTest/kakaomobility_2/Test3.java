package com.example.kotlinTest.kakaomobility_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Test3 {
    Solution solution = new Solution();

    @Test
    void tes1 () {
        Assertions.assertThat(solution.solution(
                new int[]{3,2,3,2,3}
        )).isEqualTo(5);


    }

    @Test
    void tes2 () {
        Assertions.assertThat(solution.solution(
                new int[]{7, 4, -2, 4, -2, -9}
        )).isEqualTo(4);
    }
    @Test
    void tes3 () {
        Assertions.assertThat(solution.solution(
                new int[]{7, -5, -5, -5, 7, -1, 7}
        )).isEqualTo(3);
    }

    @Test
    void tes4 () {
        Assertions.assertThat(solution.solution(
                new int[]{4}
        )).isEqualTo(1);
    }

    class Solution {
        public int solution(int[] A) {
            if (A.length == 1) {
                return 1;
            }
            int maxLen = 0;
            int len = 2;

            for (int i = 2; i < A.length ; i++) {
                if (A[i-2] == A[i]) {
                    len++;
                    maxLen = Math.max(maxLen, len);
                    continue;
                }
                len = 2;
            }


            return maxLen;
        }
    }
}

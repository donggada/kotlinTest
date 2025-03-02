package com.example.kotlinTest.codility.timeComplexity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(10, 85, 30)
        ).isEqualTo(
                3
        );
    }


    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(10, 10, 30)
        ).isEqualTo(
                0
        );
    }

    class Solution {
        public int solution(int X, int Y, int D) {
            int a = (Y - X) / D;
            int b = (Y - X) % D > 0 ? 1 : 0;

            return a + b;
        }
    }
}

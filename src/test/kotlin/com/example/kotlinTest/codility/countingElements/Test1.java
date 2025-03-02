package com.example.kotlinTest.codility.countingElements;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4})
        ).isEqualTo(
                6
        );
    }

    class Solution {
        public int solution(int X, int[] A)
        {
            return 0;
        }
    }
}

package com.example.kotlinTest.codility.Iterations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(9)
        ).isEqualTo(
                2
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(32)
        ).isEqualTo(
                0
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(33)
        ).isEqualTo(
                4
        );
    }



    class Solution {
        public int solution(int N) {
            String binaryString = Integer.toBinaryString(N);
            int maxCount = 0;
            int count = 0;
            for (int i = 0; i <binaryString.length() ; i++) {
                char c = binaryString.charAt(i);
                if (c == '1') {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                    continue;
                }
                count++;
            }

            return maxCount;
        }
    }


}

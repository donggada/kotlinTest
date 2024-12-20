package com.example.kotlinTest.시큐레터;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Test1 {

    @Test
    void case1() {
        Assertions.assertThat(
                new Solution().solution(4)
        ).isEqualTo(5);
    }

    @Test
    void case2() {
        Assertions.assertThat(
                new Solution().solution(12)
        ).isEqualTo(13);
    }


    @Test
    void case3() {
        Assertions.assertThat(
                new Solution().solution(5)
        ).isEqualTo(-1);
    }


    class Solution {
        public int solution(int b) {
            int answer = -1;

            for (long a = 1; a <= b; a++) {
                long val = a * a + (long) b * b;
                if (isPerfectSquare(val)) {
                    return (int) Math.sqrt(val);
                }
            }

            return answer;
        }

        private boolean isPerfectSquare (long num) {
            long sqrt = (long) Math.sqrt(num);
            return sqrt * sqrt == num;
        }


    }




}

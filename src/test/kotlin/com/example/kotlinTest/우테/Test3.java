package com.example.kotlinTest.우테;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {

    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(5)
        ).isEqualTo(
                5
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(15)
        ).isEqualTo(
                2
        );
    }

    class Solution {
        public int solution(int n) {
            long length = 0;
            long digit = 1;
            long count = 9;

            while (n > length + digit * count) {
                length += digit * count;
                digit++;
                count *= 10;
            }

            long offset = n - length - 1;
            int start = (int) Math.pow(10, digit - 1);
            long number = start + offset / digit;
            int index = (int) (offset % digit);
            return String.valueOf(number).charAt(index) - '0';
        }
    }
}

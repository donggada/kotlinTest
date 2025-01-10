package com.example.kotlinTest.프로그래머스_탐욕법;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest2 {
    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution("1924", 2)
        ).isEqualTo(
                "94"
        );

        Assertions.assertThat(
                solution.solution("1231234", 3)
        ).isEqualTo(
                "3234"
        );

        Assertions.assertThat(
                solution.solution("4177252841", 4)
        ).isEqualTo(
                "775841"
        );




    }

    class Solution {
        static int max = 0;

        public String solution(String number, int k) {
            for (int i = 0; i < number.length() - k ; i++) {
                self(String.valueOf(number.charAt(i)), i, number, k);
            }

            return String.valueOf(max);
        }

        private void self (String val, int index, String number, int k) {
            if (val.length() == number.length() - k) {
                max = Math.max(max, Integer.parseInt(val));
                return;
            }

            for (int i = index + 1; i < number.length() ; i++) {
                self(val + number.charAt(i), i , number, k);
            }
        }
    }
}

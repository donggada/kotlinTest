package com.example.kotlinTest.월간코챌린시즌1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
          solution.solution("110010101001")
        ).isEqualTo(
                new int[]{3,8}
        );

        Assertions.assertThat(
                solution.solution("01110")
        ).isEqualTo(
                new int[]{3,3}
        );

        Assertions.assertThat(
                solution.solution("1111111")
        ).isEqualTo(
                new int[]{4,1}
        );
    }

    class Solution {
        public int[] solution(String s) {
            int count = 0;
            int removeCount = 0;

            while (!s.equals("1")) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length() ; i++) {
                    char c = s.charAt(i);
                    if (c == '0') {
                        removeCount++;
                    }

                    if (c == '1') {
                        sb.append(c);
                    }
                }

                s = Integer.toBinaryString(sb.toString().length());
                count++;
            }


            return new int[]{count, removeCount};
        }
    }
}

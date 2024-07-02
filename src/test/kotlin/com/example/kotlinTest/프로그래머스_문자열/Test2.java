package com.example.kotlinTest.프로그래머스_문자열;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test2 {
    @Test
    void case1() {
        Solution solution = new Solution();
        assertThat(
                solution.solution(78)
        ).isEqualTo(
                83
        );
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        assertThat(
                solution.solution(15)
        ).isEqualTo(
                23
        );
    }

    class Solution {
        public int solution(int n) {
            int answer = 0;
            String binaryString = Integer.toBinaryString(n);
            int count = 0;

            for (int i = 0; i < binaryString.length() ; i++) {
                if (binaryString.charAt(i) == '1') {
                    count++;
                }
            }

            while (true) {
                n++;
                if (check(n, count)) {
                    return n;
                }
            }
        }

        private boolean check(int n, int count) {
            int cnt = 0;
            String binaryString = Integer.toBinaryString(n);

            for (int i = 0; i < binaryString.length() ; i++) {
                if (binaryString.charAt(i) == '1') {
                    cnt++;
                }
            }


            return count == cnt;
        }
    }
}


package com.example.kotlinTest.kakao2018;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test8_n진수게 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(2,	4,	2,	1)
        ).isEqualTo(
                "0111"
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(16, 16, 2, 1)
        ).isEqualTo(
                "02468ACE11111111"
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(16, 16, 2, 2)
        ).isEqualTo(
                "13579BDF01234567"
        );
    }

    class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new  StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < t * m; i++) {
                sb.append(Integer.toString(i, n));
            }

            for (int i = p-1; answer.length() < t ; i+=m) {
                answer.append(sb.charAt(i));
            }

            return answer.toString().toUpperCase();
        }
    }

}
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test7 {

    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(5)
        ).isEqualTo(
                2
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(6)
        ).isEqualTo(
                2
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(5000)
        ).isEqualTo(
                5
        );
    }


    public class Solution {
        public int solution(int n) {
            int ans = 0;
            while (n > 0) {

                if (n % 2 == 1) {
                    ans++;
                }

                n /= 2;
            }
            return ans;
        }
    }
}

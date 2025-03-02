

package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test24 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(1)
        ).isEqualTo(
                "1"
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(2)
        ).isEqualTo(
                "2"
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(3)
        ).isEqualTo(
                "4"
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(4)
        ).isEqualTo(
                "11"
        );
    }

    @Test
    void case5() {
        Assertions.assertThat(
                solution.solution(13)
        ).isEqualTo(
                "111"
        );
    }


    class Solution {
        public String solution(int n) {
            StringBuilder answer = new StringBuilder();
            String[] numbers = {"4", "1", "2"};

            while (n > 0) {
                int num = n % 3;

                if (num == 0) {
                    n--;
                }

                answer.insert(0, numbers[num]);

                n /= 3;
            }
            return answer.toString();
        }
    }

}
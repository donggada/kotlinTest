
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test21 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(16)
        ).isEqualTo(
                6
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(2554)
        ).isEqualTo(
                16
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(3000)
        ).isEqualTo(
                3
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(3003)
        ).isEqualTo(
                6
        );
    }


    @Test
    void case5() {
        Assertions.assertThat(
                solution.solution(1051)
        ).isEqualTo(
                7
        );
    }


    @Test
    void case6() {
        Assertions.assertThat(
                solution.solution(91)
        ).isEqualTo(
                3
        );
    }


    class Solution {
        public int solution(int storey) {
            int answer = 0;
            while (storey > 0) {
                int n = storey %  10;
                storey /= 10;

                if (n > 5) {
                    answer += 10 - n;
                    storey++;
                    continue;
                }

                if (n < 5) {
                    answer += n;
                    continue;
                }

                if (storey % 10 >= 5) {
                    answer += 5;
                    storey++;
                    continue;
                }

                answer += 5;
            }

            return answer;
        }
    }








}
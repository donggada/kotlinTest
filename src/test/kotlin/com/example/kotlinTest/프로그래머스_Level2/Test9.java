
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Test9 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(8, 4, 7)
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(8, 1, 2)
        ).isEqualTo(
                1
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(8, 1, 4)
        ).isEqualTo(
                2
        );
    }




    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;

            while (a != b) {
                a = a /2 + a % 2;
                b = b /2 + b % 2;
                answer++;
            }

            return answer;
        }
    }
}

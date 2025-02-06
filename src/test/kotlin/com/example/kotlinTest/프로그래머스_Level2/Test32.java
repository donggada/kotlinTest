

package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test32 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        2,4
                )

        ).isEqualTo(
                6
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        1,5
                )
        ).isEqualTo(
                26
        );
    }


    class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            for (int i = 0; i <= d; i+=k) {
                answer += (long) (Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2)) / k+1);
            }
            return answer;
        }
    }
}
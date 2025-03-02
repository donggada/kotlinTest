package com.example.kotlinTest.프로그래머스.프로그래머스_완전탐색;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest6 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})
        ).isEqualTo(
            3
        );

        Assertions.assertThat(
            solution.solution(4, new int[][]{{1,2},{2,3},{3,4}})
        ).isEqualTo(
            0
        );

        Assertions.assertThat(
            solution.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}})
        ).isEqualTo(
            1
        );

    }

    class Solution {
        public int solution(int n, int[][] wires) {
            int answer = -1;
            return answer;
        }
    }

}

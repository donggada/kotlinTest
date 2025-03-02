package com.example.kotlinTest.프로그래머스.프로그래머스_완전탐색;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest1 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})
        ).isEqualTo(
            4000
        );

        Assertions.assertThat(
            solution.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})
        ).isEqualTo(
            120
        );

        Assertions.assertThat(
            solution.solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})
        ).isEqualTo(
            133
        );


    }

    class Solution {
        public int solution(int[][] sizes) {
            int length = 0;
            int height = 0;

            for (int[] size : sizes) {
                int w = size[0];
                int h = size[1];

                length = Math.max(length, Math.max(w, h));
                height = Math.max(height, Math.min(w, h));

            }
            return length * height;
        }
    }

}

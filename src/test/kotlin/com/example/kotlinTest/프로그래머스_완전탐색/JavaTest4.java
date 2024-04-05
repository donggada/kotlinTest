package com.example.kotlinTest.프로그래머스_완전탐색;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JavaTest4 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(10, 2)
        ).isEqualTo(new int[] {4, 3});

        Assertions.assertThat(
                solution.solution(8, 1)
        ).isEqualTo(new int[] {3, 3});

        Assertions.assertThat(
                solution.solution(24, 24)
        ).isEqualTo(new int[] {8, 6});




    }

    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};
            ArrayList<Integer> currList = new ArrayList<>();
            for (int col = 1; col <= yellow ; col++) {
                if (yellow % col == 0) {
                    int row = yellow / col;
                    if ((row + col) * 2 + 4 == brown) {
                        return new int[]{Math.max(row , col) + 2, Math.min(row , col) + 2 };
                    }
                }
            }
            return answer;
        }
    }

}

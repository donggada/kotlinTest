package com.example.kotlinTest.codility.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test4 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{1,5,2,1,4,0})
        ).isEqualTo(
                11
        );
    }


    class Solution {
        public int solution(int[] A) {
            return 0;
        }
    }
}

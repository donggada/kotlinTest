package com.example.kotlinTest.codility.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test3 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{10,1,5,1,8,20})
        ).isEqualTo(
                1
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{10,50,5,1})
        ).isEqualTo(
                0
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new int[]{5,8,10})
        ).isEqualTo(
                1
        );
    }


    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(new int[]{})
        ).isEqualTo(
                0
        );
    }

    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);

            for (int i = 0; i < A.length-2 ; i++) {
                if (A[i] + A[i+1] > A[i+2]) {
                    return 1;
                }
            }

            return 0;
        }
    }
}

package com.example.kotlinTest.codility.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Test2 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{-3,1,2,-2,5,6})
        ).isEqualTo(
                60
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{-20,-50, -1,2,5,6})
        ).isEqualTo(
                6000
        );
    }

    class Solution {
        public int solution(int[] A) {
            int length = A.length;
            if (length == 3) {
                return A[0] * A[1] * A[2];
            }

            Arrays.sort(A);
            int max = Integer.MIN_VALUE;

            max = Math.max(max, A[length-1] * A[length-2] *A[length-3]);
            max = Math.max(max, A[0] * A[1] *A[length-1]);
            return max;
        }
    }
}

package com.example.kotlinTest.codility.timeComplexity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.channels.FileChannel;

public class Test3 {

    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{3,1,2,4,3})
        ).isEqualTo(
                1
        );
    }


    class Solution {
        public int solution(int[] A) {
            int total = 0;
            for (int a : A) {
                total += a;
            }
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < A.length-1 ; i++) {
                sum += A[i];
                min = Math.min(min, Math.abs(sum - (total - sum)));
            }
            return min;
        }
    }
}

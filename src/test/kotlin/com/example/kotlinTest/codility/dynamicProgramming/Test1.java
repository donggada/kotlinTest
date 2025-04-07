package com.example.kotlinTest.codility.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test1 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{1, -2, 0, 9, -1, -2})
        ).isEqualTo(
          8
        );

    }

    class Solution {
        public int solution (int[] A) {
            int length = A.length;
            int[] dp = new int[length];
            dp[0] = A[0];
            for (int i = 1; i < length ; i++) {
                int val = dp[i-1] + A[i];
                for (int j = 2; j <= 6 ; j++) {
                    if (i-j < 0) {
                        continue;
                    }
                    val = Math.max(val, dp[i-j] + A[i]);
                }
                dp[i] = val;
            }
            return dp[length-1];
        }
    }

}

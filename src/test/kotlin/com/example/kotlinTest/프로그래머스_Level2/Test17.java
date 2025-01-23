
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test17 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(4)
        ).isEqualTo(
                5
        );
    }

    class Solution {
        public int solution(int n) {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;

            for(int i = 3; i < n+1; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }

            return dp[n];
        }
    }

}
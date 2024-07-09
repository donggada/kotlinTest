package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class Test5 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution(
                        10, 40, 30
                )
        ).isEqualTo(
                1
        );
    }

    @Test
    void case2() {
        assertThat(
                new Solution().solution(
                        10 ,40, 5
                )
        ).isEqualTo(
                2
        );
    }

    @Test
    void case3() {
        assertThat(
                new Solution().solution(
                        2, 5,4
                )
        ).isEqualTo(
                -1
        );
    }

    class Solution {
        public int solution(int x, int y, int n) {
            int[] dp = new int[y + 1];

            for (int i = x; i < y + 1; i++) {
                if (i != x && dp[i] == 0) {
                    dp[i] = -1;
                    continue;
                }

                if (i + n <= y) {
                    dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
                }

                if (2 * i <= y) {
                    dp[2 * i] = dp[2 * i] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[2 * i]);
                }

                if (3 * i <= y) {
                    dp[3 * i] = dp[3 * i] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[3 * i]);
                }

            }
            return dp[y];
        }

    }

}

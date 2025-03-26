package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test6 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10})
        ).isEqualTo(
            36
        );

    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{1, 3, 2, 5, 4})
        ).isEqualTo(
                8
        );

    }

    class Solution {
        public int solution(int sticker[]) {
            int len = sticker.length;
            if (sticker.length == 1) {
                return sticker[0];
            }

            int[] dp1 = new int[len];
            dp1[0] = sticker[0];
            dp1[1] = sticker[0];
            // 첫번쨰 선택 DP
            for (int i = 2; i < len - 1; i++) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            }

            int[] dp2 = new int[len];
            dp2[1] = sticker[1];
            // 두번쨰 선택 DP
            for (int i = 2; i < len; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
            }

            return Math.max(dp1[len - 2], dp2[len - 1]);
        }
    }
}

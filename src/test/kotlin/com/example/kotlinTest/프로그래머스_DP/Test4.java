package com.example.kotlinTest.프로그래머스_DP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test4 {
    @Test
    void case1() {

        Assertions.assertThat(new Solution().solution(new int[]{1,2,3,1})).isEqualTo(4);
    }

    class Solution {
        public int solution(int[] money) {
            int size = money.length;

            int [] dp1 =new int[size];
            int [] dp2 =new int[size];

            dp1[0] = money[0];
            dp1[1] = money[0];

            dp2[0] = 0;
            dp2[1] = money[1];

            for (int i = 2; i < size ; i++) {
                 dp1[i] = Math.max(money[i] + dp1[i-2], dp1[i-1]);
                 dp2[i] = Math.max(money[i] + dp2[i-2], dp2[i-1]);
            }

            return Math.max(dp1[size-2], dp2[size-1]);
        }
    }
}

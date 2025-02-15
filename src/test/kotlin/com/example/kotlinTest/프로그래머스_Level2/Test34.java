package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test34 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(solution.solution(2,3)).isEqualTo(20);
    }

    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            for (int i = 1; i <= r2 ; i++) {
                long maxLen = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(i,2));
                long minLen = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i,2)));
                answer += maxLen - minLen + 1;
            }

            return answer * 4;
        }
    }

}

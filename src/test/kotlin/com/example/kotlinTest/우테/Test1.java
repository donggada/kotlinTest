package com.example.kotlinTest.우테;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    Solution solution = new Solution ();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{100000, -200000, 100000, -300000}, 11)
        ).isEqualTo(330);
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{70000, -100000, -10000, -50000, 80000}, 4)
        ).isEqualTo(36);
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new int[]{70000,  80000}, 4)
        ).isEqualTo(0);
    }

    class Solution {
        public int solution(int[] transactions, int rate) {
            int answer = 0;

            int currentAmount = 0;

            for (int t : transactions) {
                currentAmount += t;
                if(currentAmount < 0) {
                    answer = Math.max(answer, Math.abs(currentAmount));
                }
            }

            return answer * rate / 10000;
        }
    }

}

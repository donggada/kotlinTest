package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test40 {


    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(0,5,30, 0, 7, 0)
        ).isEqualTo(
                2
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(12,0,0,12,0,30)
        ).isEqualTo(
                1
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(0,6,1,0,6,6)
        ).isEqualTo(
                0
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(11,59,30,12,0,0)
        ).isEqualTo(
                1
        );
    }

    @Test
    void case5() {
        Assertions.assertThat(
                solution.solution(11,58,59,11,59,0)
        ).isEqualTo(
                1
        );
    }

    @Test
    void case6() {
        Assertions.assertThat(
                solution.solution(1,5,5,1,5,6)
        ).isEqualTo(
                2
        );
    }

    @Test
    void case7() {
        Assertions.assertThat(
                solution.solution(0,0,0,23,59,59)
        ).isEqualTo(
                2852
        );
    }

    class Solution {
        public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int startTime = toSecond(h1, m1, s1);
            int endTime = toSecond(h2, m2, s2);
            return cal(endTime) - cal(startTime) + (isAlarmNow(startTime) ? 1 :0);
        }
        private int cal (int t) {
            int hourCount = t * 719 / (60 * 60 * 12);
            int minCount = t * 59 / (60 * 60);
            int duplicateCount = (60 * 60 * 12) <= t ? 2 : 1;
            return hourCount + minCount - duplicateCount;
        }

        private int toSecond(int h, int m, int s) {
            return h * 60 * 60 + m * 60 + s;
        }

        private boolean isAlarmNow(int time) {
            return time * 59 / 3600 == 0 || time * 719 % (60 * 60 * 12) == 0;
        }
    }
}

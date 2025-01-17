package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test6 {
    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{2, 6, 8, 14})
        ).isEqualTo(
                168
        );
    }

    @Test
    void cass2() {
        Assertions.assertThat(
                solution.solution(new int[]{1,2,3})
        ).isEqualTo(
                6
        );
    }

    class Solution {
        public int solution(int[] arr) {
            int answer = arr[0];
            for (int i = 1; i < arr.length ; i++) {
                int gcd = gcd(arr[i - 1], arr[i]);
                answer = answer * arr[i] / gcd;
            }
            return answer;
        }

        private int gcd (int a, int b) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);

            while (max % min != 0) {
                int r = max % min;
                max = min;
                min = r;
            }

            return min;
        }
    }
}



package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test25 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{10, 17},
                        new int[]{5, 20}
                )
        ).isEqualTo(
                0
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{10, 20},
                        new int[]{5, 17}
                )
        ).isEqualTo(
                10
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{14, 35, 119},
                        new int[]{18, 30, 102}
                )
        ).isEqualTo(
                7
        );
    }




    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;

            int aGcd = arrayA[0];
            int bGcd = arrayB[0];


            for (int i = 1; i < arrayA.length ; i++) {
                 aGcd = gcd(aGcd, arrayA[i]);
                 bGcd = gcd(bGcd, arrayB[i]);
            }

            if (check(aGcd, arrayB)) {
                answer = Math.max(answer, aGcd);
            }

            if (check(bGcd, arrayA)) {
                answer = Math.max(answer, bGcd);
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

        private boolean check (int gcd, int[] arr) {
            for (int a: arr) {
                if (a % gcd == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}


package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test33 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{1,5,3},
                        new int[]{2,4,7},
                        30
                )

        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{1, 4, 4, 2},
                        new int[]{6, 3, 8, 2},
                        59L
                )

        ).isEqualTo(
                2
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{1, 328, 467, 209, 54},
                        new int[]{2, 7, 1, 4, 3},
                        1723L
                )

        ).isEqualTo(
                294
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{1, 99999, 100000, 99995},
                        new int[]{9999, 9001, 9999, 9001},
                        3456789012L
                )

        ).isEqualTo(
                39354
        );
    }

    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int level = Integer.MAX_VALUE;
            int start = 1;
            int end = Arrays.stream(diffs).max().getAsInt();

            while (start <= end) {
                int mid = (start + end) / 2;
                if (isLevel(mid, diffs, times, limit)) {
                    end = mid -1;
                    level = Math.min(level, mid);
                    continue;
                }

                start = mid +1;
            }

            return level;
        }

        private boolean isLevel(int level, int[] diffs, int[] times, long limit) {
            long sumTime = 0;

            for (int i = 0; i < diffs.length ; i++) {
                long count = diffs[i] - level;

                if (count <= 0) {
                    sumTime += times[i];
                    continue;
                }

                if (i == 0) {
                    sumTime += times[i];
                }

                sumTime += count * (times[i-1] + times[i]) + times[i];
            }

            return sumTime <= limit;
        }
    }
}
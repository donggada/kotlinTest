package com.example.kotlinTest.프로그래머스.프로그래머스_탐욕법;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void case1() {
        Assertions.assertThat(
                new Solution().solution(
                        5, new int[]{2,4}, new int[]{1,3,5}
                )
        ).isEqualTo(
                5
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                new Solution().solution(
                        5, new int[]{2,4}, new int[]{3}
                )
        ).isEqualTo(
                4
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                new Solution().solution(
                        3, new int[]{3}, new int[]{1}
                )
        ).isEqualTo(
                2
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                new Solution().solution(
                        5, new int[]{3}, new int[]{3}
                )
        ).isEqualTo(
                5
        );
    }


    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int[] arr = new int[n];

            for (int i : lost) {
                arr[i - 1] -= 1;
            }

            for (int i : reserve) {
                arr[i - 1] += 1;
            }

            for (int i = 0; i < n ; i++) {
                if (arr[i] > -1) {
                    answer++;
                    continue;
                }

                if (i > 0) {
                    if (arr[i-1] > 0) {
                        arr[i-1] -= 1;
                        answer++;
                        continue;
                    }
                }

                if (i < n-1) {
                    if (arr[i+1] > 0) {
                        arr[i+1] -= 1;
                        answer++;
                    }
                }
            }

            return answer;
        }
    }
}

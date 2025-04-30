package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test11 {
    
    Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}})
        ).isEqualTo(
                4
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[][]{{2, 1}, {1, 4}, {3, 2}, {3, 2}, {2, 1}})
        ).isEqualTo(
                -1
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new int[][]{{1, 3}, {1, 4},{1,4}, {5, 2}, {5, 2}, {1,3}})
        ).isEqualTo(
                5
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(new int[][]{{102, 3}, {100, 101}, {99, 90}})
        ).isEqualTo(
                2
        );
    }
    class Solution {
        public int solution(int[][] scores) {
            int answer = 1;
            int[] wanHoScore = scores[0];
            int score = 0;

            Arrays.sort(scores, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr2[0] - arr1[0]);


            for (int[] s : scores) {
                if (wanHoScore[0] < s[0] && wanHoScore[1] < s[1]) {
                    return -1;
                }

                if (score <= s[1]) {
                    score = s[1];
                    if (s[0] + s[1] > wanHoScore[0] + wanHoScore[1]) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }

    
}

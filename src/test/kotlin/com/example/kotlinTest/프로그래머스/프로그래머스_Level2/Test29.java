

package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test29 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[][]{
                                {2, 2, 6},
                                {1, 5, 10},
                                {4, 2, 9},
                                {3, 8, 3}
                        },
                        2,
                        2,
                        3
                )
        ).isEqualTo(
                4
        );
    }


    class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;
            Arrays.sort(data, (arr1, arr2) -> arr1[col-1] != arr2[col-1]? arr1[col-1] - arr2[col-1] : arr2[0] - arr1[0]);

            for (int i = row_begin; i <= row_end ; i++) {
                int hash = 0;
                for (int n : data[i-1]) {
                    hash += (n % i);
                }
                answer ^= hash;
            }
            return answer;
        }
    }

}
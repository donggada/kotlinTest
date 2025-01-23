
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test16 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}})
        ).isEqualTo(
                16
        );
    }

    class Solution {
        int solution(int[][] land) {
            for (int i = 1; i <land.length ; i++) {
                land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
                land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
                land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
                land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
                continue;
            }

            int[] arr = land[land.length-1];
            Arrays.sort(arr);
            return arr[3];
        }
    }

}
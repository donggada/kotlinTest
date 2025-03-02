package com.example.kotlinTest.codility.timeComplexity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {

    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{2, 3, 1, 5})
        ).isEqualTo(
                4
        );
    }


    class Solution {
        public int solution(int[] A) {
            boolean[] arr = new boolean[A.length + 2];

            for (int a : A) {
                arr[a] = true;
            }

            for (int i = 1; i < arr.length ; i++) {
                if (!arr[i]) {
                    return i;
                }
            }

            return -1;
        }
    }
}

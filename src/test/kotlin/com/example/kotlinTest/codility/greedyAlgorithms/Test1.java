package com.example.kotlinTest.codility.greedyAlgorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {
    Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{1,3,7,9,9}, new int[]{5,6,8,9,10})
        ).isEqualTo(
            3
        );
    }


    class Solution {
        public int solution(int[] A, int[] B) {
            int count = 1;
            int len = A.length;

            if (len <= 1) {
                return len;
            }

            int index = 0;
            for (int i = 1; i < len ; i++) {
                if (A[i] > B[index]) {
                    count++;
                    index = i;
                }
            }

            return count;
        }
    }

}

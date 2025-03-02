package com.example.kotlinTest.codility.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Test1 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{2,1,1,2,3,1})
        ).isEqualTo(
                3
        );
    }

    class Solution {
        public int solution(int[] A) {
            HashSet<Integer> set = new HashSet<>();
            for (int a : A) {
                set.add(a);
            }
            return set.size();
        }
    }
}

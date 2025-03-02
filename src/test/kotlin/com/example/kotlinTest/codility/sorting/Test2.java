package com.example.kotlinTest.codility.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Test2 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{-3,1,2,-2,5,6})
        ).isEqualTo(
                60
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{-20,-50, -1,2,5,6})
        ).isEqualTo(
                6000
        );
    }

    class Solution {
        public int solution(int[] A) {
            ArrayList<Integer> minus = new ArrayList<>();
            ArrayList<Integer> plus = new ArrayList<>();
            for (int a : A) {
                if (a >= 0) {
                    plus.add(a);
                    continue;
                }
                minus.add(a);
            }



            return 0;
        }
    }
}

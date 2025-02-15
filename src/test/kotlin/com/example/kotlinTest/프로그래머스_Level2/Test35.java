package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Test35 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[][]{
                        {4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}
                })
        ).isEqualTo(
                3
        );
    }

    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;
            Arrays.sort(targets, Comparator.comparingInt(arr -> arr[1]));
            int end = 0;
            for (int[] target : targets) {
                if (target[0] >= end) {
                    end = target[1];
                    answer++;
                }
            }

            return answer;
        }
    }
}

package com.example.kotlinTest.프로그래머스_이분탐색;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class Test1 {

    @Test
    void  test() {
        Solution solution = new Solution();



        Assertions.assertThat(
                solution.solution(6, new int[]{7, 10})
        ).isEqualTo(28);


    }

    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            return answer;
        }
    }
}

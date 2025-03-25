package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test3 {
    
    Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(2, 9)
        ).isEqualTo(
                new int[] {4,5}
        );
        
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(2, 1)
        ).isEqualTo(
                new int[] {-1}
        );

    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(2, 8)
        ).isEqualTo(
                new int[] {4,4}
        );

    }

    class Solution {
        public int[] solution(int n, int s) {
            if (s / n == 0) {
                return new int[]{-1};
            }

            int[] answer = new int[n];
            int index = 0;

            while (n != 0) {
                int val = s / n;
                answer[index] = val;
                s -= val;
                index++;
                n--;
            }

            Arrays.sort(answer);


            return answer;
        }
    }
    
}

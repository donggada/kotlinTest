package com.example.kotlinTest.온다;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

public class Test1 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution(new int[][]{{1,4},{3,5},{8,10}})
        ).isEqualTo(6);
    }

    @Test
    void case2() {
        assertThat(
                new Solution().solution(new int[][]{{1,2},{3,4}})
        ).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(
                new Solution().solution(new int[][]{{1,10},{2,8},{3,5}})
        ).isEqualTo(9);
    }

    @Test
    void case4() {
        assertThat(
                new Solution().solution(new int[][]{{200,300},{100,200}})
        ).isEqualTo(200);
    }
    class Solution {
        public int solution(int[][] customer) {
            int answer = 0;
            Arrays.sort(customer, Comparator.comparingInt(a -> a[0]));

            int currentStart = customer[0][0];
            int currentEnd = customer[0][1];

            for (int i = 1; i < customer.length; i++) {
                int start = customer[i][0];
                int end = customer[i][1];

                if (start <= currentEnd) {
                    currentEnd = Math.max(currentEnd, end);
                } else {
                    answer += currentEnd - currentStart;
                    currentStart = start;
                    currentEnd = end;
                }
            }

            answer += currentEnd - currentStart;
            return answer;
        }
    }
}

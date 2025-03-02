
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test12 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(3, 2,5)
        ).isEqualTo(
                new int[]{3, 2, 2, 3}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(4, 7,14)
        ).isEqualTo(
                new int[]{4,3,3,3,4,4,4,4}
        );
    }

    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = {};

            ArrayList<Integer> list = new ArrayList<>();

            while (left <= right) {
                long row = left / n;
                list.add((int) Math.max(row + 1, left % n +1));
                left++;
            }

            answer = new int[list.size()];

            for (int i = 0; i <list.size() ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

}
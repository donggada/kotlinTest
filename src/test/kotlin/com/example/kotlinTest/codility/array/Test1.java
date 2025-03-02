package com.example.kotlinTest.codility.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test1 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{3, 8, 9, 7, 6}, 3)
        ).isEqualTo(
                new int[]{9, 7, 6, 3, 8}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{1,2,3,4}, 4)
        ).isEqualTo(
                new int[]{1,2,3,4}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new int[]{1,2}, 0)
        ).isEqualTo(
                new int[]{1,2}
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(new int[]{1,2,3}, 1)
        ).isEqualTo(
                new int[]{3,1,2}
        );
    }

    @Test
    void case5() {
        Assertions.assertThat(
                solution.solution(new int[]{1, 2, 3, 5, 1}, 3)
        ).isEqualTo(
                new int[]{3, 5, 1, 1, 2}
        );
    }

    class Solution {
        public int[] solution(int[] A, int K) {
            int len = A.length;
            if (K == 0 || len == 0) {
                return  A;
            }

            Deque<Integer> stack = new ArrayDeque<>();
            for (int a : A) {
                stack.addLast(a);
            }


            for (int i = 0; i < K; i++) {
                Integer last = stack.getLast();
                stack.removeLast();
                stack.addFirst(last);
            }

            int[] result = new int[len];

            for (int i = 0; i < len; i++) {
                result[i] = stack.pop();
            }

            return result;
        }
    }

}

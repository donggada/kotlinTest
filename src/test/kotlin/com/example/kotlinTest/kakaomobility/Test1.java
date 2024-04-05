package com.example.kotlinTest.kakaomobility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {
    @Test
    void test () {
        Solution solution = new Solution();

        solution.solution(54321);
        solution.solution(10011);
        solution.solution(1);

    }

    class Solution {
        public void solution(int N) {
            int enable_print = 0;
            while (N > 0) {
                if (N % 10 != 0) {
                    enable_print = 1;
                }
                if (enable_print == 1) {
                    System.out.print(N % 10);
                }
                N = N / 10;
            }
//            System.out.println();
        }

    }
}

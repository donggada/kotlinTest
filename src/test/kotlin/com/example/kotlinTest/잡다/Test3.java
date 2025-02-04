package com.example.kotlinTest.잡다;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test3 {
    Solution solution = new Solution();


    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        2,
                        1,
                        4,
                        new int[][]{{1,4}},
                        2)
        ).isEqualTo(
                1
        );
    }

    class Solution {
        public int solution(int N, int M, int H, int[][] S, int C) {
            int answer = 0;
            boolean[][] ladder = new boolean[H+1][N+1];

            for (int[] s : S) {
                int y = s[0];
                int x = s[1];
                ladder[y][x] = true;
            }

            for (int i = 1; i <= N ; i++) {
                if (simulate(i, N, H, ladder) == C) {
                    return i;
                }
            }
            return -1;
        }

        private int simulate(int i, int n, int h, boolean[][] ladder) {
            int x = i;
            for (int j = 1; j <= h ; j++) {
                if (x < n && ladder[j][x])   {
                    x++;
                    continue;
                }
                if (x > 1 && ladder[j][x-1]) {
                    x--;
                }
            }
            return x;
        }
    }
}



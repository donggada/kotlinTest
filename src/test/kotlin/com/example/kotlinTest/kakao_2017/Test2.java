package com.example.kotlinTest.kakao_2017;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test2 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                        3, 3,
                        new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
                )
        ).isEqualTo(
                6
        );

        Assertions.assertThat(
                solution.solution(
                        3, 6,
                        new int[][] {
                                {0, 2, 0, 0, 0, 2},
                                {0, 0, 2, 0, 1, 0},
                                {1, 0, 0, 2, 2, 0}
                        }
                )
        ).isEqualTo(
                2
        );

        Assertions.assertThat(
                solution.solution(
                        3, 6,
                        new int[][] {
                                {0, 1, 0, 1, 0, 2},
                                {1, 0, 2, 0, 1, 0},
                                {0, 0, 0, 2, 2, 0}
                        }
                )
        ).isEqualTo(
                0
        );
    }

    class Solution {
        int MOD = 20170805;

        public int solution(int m, int n, int[][] cityMap) {
            int[][][] val = new int[m][n][2];
            //0 밑으로, 1 옆으로
            if (cityMap[0][0] == 1) {
                return 0;
            }

            val[0][0][0] = 1;
            val[0][0][1] = 1;

            for (int i = 1; i < m ; i++) {
                if (cityMap[i][0] != 1) {
                    val[i][0][0] = val[i-1][0][0];
                }
            }

            for (int i = 1; i < n ; i++) {
                if (cityMap[0][i] != 1) {
                    val[0][i][1] = val[0][i-1][1];
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {

                    if (cityMap[i - 1][j] == 2) {
                        val[i][j][0] = val[i - 1][j][0];
                    }

                    if (cityMap[i - 1][j] == 0) {
                        val[i][j][0] = (val[i - 1][j][0] + val[i - 1][j][1]) % MOD;
                    }

                    if (cityMap[i][j - 1] == 2) {
                        val[i][j][1] = val[i][j - 1][1];
                    }

                    if (cityMap[i][j - 1] == 0) {
                        val[i][j][1] = (val[i][j - 1][0] + val[i][j - 1][1]) % MOD;
                    }

                }
            }

            return (val[m - 1][n - 1][0] + val[m - 1][n - 1][1]) % MOD;
        }
    }
}

//        [0, 1] [1, 0] [1, 0] [1, 0] [1, 0] [1, 0]
//        [0, 1] [1, 1] [1, 2] [1, 2] [0, 0] [1, 0]
//        [0, 0] [2, 0] [1, 2] [3, 3] [0, 3] [1, 3]

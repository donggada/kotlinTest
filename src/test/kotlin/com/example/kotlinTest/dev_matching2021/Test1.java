package com.example.kotlinTest.dev_matching2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    Solution solution = new Solution();


    @Test
    void case1() {
        Assertions.assertThat(solution.solution(
                        6,
                        6,
                        new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}
                )
        ).isEqualTo(
                new int[]{8, 10, 25}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(solution.solution(
                        3,
                        3,
                        new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}
                )
        ).isEqualTo(
                new int[]{1, 1, 5, 3}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(solution.solution(
                        100,
                        97,
                        new int[][]{{1,1,100,97}}
                )
        ).isEqualTo(
                new int[]{1}
        );
    }

    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            return rotateNums(intiArr(rows, columns), queries);
        }

        private int[][] intiArr(int rows, int columns) {
            int[][] arr = new int[rows][columns];
            int val = 1;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = val;
                    val++;
                }
            }
            return arr;
        }

        public int[] rotateNums(int[][] square, int[][] queries) {
            int[] answer = new int[queries.length];
            int minimalsIdx = 0;

            for (int[] query : queries) {
                int x1 = query[0] - 1;
                int y1 = query[1] - 1;
                int x2 = query[2] - 1;
                int y2 = query[3] - 1;
                int firstNum = square[x1][y2];
                int min = firstNum;

                // 숫자를 우로 이동 (상단)
                for (int i = y2 - 1; i >= y1; i--) {
                    min = Math.min(min, square[x1][i]);
                    square[x1][i + 1] = square[x1][i];
                }

                // 숫자를 위로 이동 (좌측)
                for (int i = x1 + 1; i <= x2; i++) {
                    min = Math.min(min, square[i][y1]);
                    square[i - 1][y1] = square[i][y1];
                }

                // 숫자를 좌로 이동 (하단)
                for (int i = y1 + 1; i <= y2; i++) {
                    min = Math.min(min, square[x2][i]);
                    square[x2][i - 1] = square[x2][i];
                }

                // 숫자를 아래로 이동 (우측)
                for (int i = x2 - 1; i >= x1; i--) {
                    min = Math.min(min, square[i][y2]);
                    square[i + 1][y2] = square[i][y2];
                }

                square[x1 + 1][y2] = firstNum;
                answer[minimalsIdx] = min;
                minimalsIdx++;
            }

            return answer;
        }
    }
}


package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test19 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[][]{
                        {1,1,0,0},
                        {1,0,0,0},
                        {1,0,0,1},
                        {1,1,1,1}
                })
        ).isEqualTo(
                new int[]{4, 9}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[][]{
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0}
                })
        ).isEqualTo(
                new int[]{1, 0}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new int[][]{
                        {1,1,1,1,1,1,1,1},
                        {0,1,1,1,1,1,1,1},
                        {0,0,0,0,1,1,1,1},
                        {0,1,0,0,1,1,1,1},
                        {0,0,0,0,0,0,1,1},
                        {0,0,0,0,0,0,0,1},
                        {0,0,0,0,1,0,0,1},
                        {0,0,0,0,1,1,1,1}
                })
        ).isEqualTo(
                new int[]{10, 15}
        );
    }

    class Solution {
        static int zeroCount = 0;
        static int oneCount = 0;
        static boolean[][] visited;
        static int[] answer = new int[2];
        public int[] solution(int[][] arr) {
            int len = arr.length;
            visited = new boolean[len][len];
            int divide = 2;

            while (divide != len) {
                int area = len / divide;
                for (int i = 0; i < len ; i += area) {
                    for (int j = 0; j < len; j += area) {
                        if (!visited[i][j]) {
                            cal(i, i + area, j, j + area, arr);
                        }
                    }
                }

                divide *= 2;
            }

            for (int i = 0; i <len ; i++) {
                for (int j = 0; j <len ; j++) {
                    if (!visited[i][j]) {
                        if (arr[i][j] == 1) {
                            oneCount++;
                            continue;
                        }
                        zeroCount++;
                    }
                }
            }

//            return new int[]{zeroCount, oneCount};
            dq(0, 0, len, arr);
            return answer;
        }

        private void cal(int x, int nx, int y, int ny, int[][] arr) {
            int num = arr[x][y];
            for (int i = x; i <nx ; i++) {
                for (int j = y; j <ny ; j++) {
                    if(arr[i][j] != num) {
                        return;
                    }
                }
            }

            for (int i = x; i <nx ; i++) {
                for (int j = y; j <ny; j++) {
                    visited[i][j] = true;
                }
            }

            if (num == 0) {
                zeroCount++;
                return;
            }

            oneCount++;
        }

        private static void dq(int x, int y, int size, int[][] arr) {
            if (check(x, y, size, arr)) {
                answer[arr[x][y]]++;
                return;
            }

            dq(x, y, size/2, arr);
            dq(x + size/2, y, size/2, arr);
            dq(x, y + size/2, size/2, arr);
            dq(x+ size/2, y + size/2, size/2, arr);
        }

        private static boolean check(int x, int y, int size, int[][] arr) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (arr[x][y] != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }








}
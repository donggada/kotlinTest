package com.example.kotlinTest.kakao2018;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test6 {
    Solution solution = new Solution();
    @Test
    void case1() {
        assertThat(
                solution.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"})
        ).isEqualTo(
                14
        );
    }

    @Test
    void case2() {
        assertThat(
                solution.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"})
        ).isEqualTo(
               15
        );
    }

    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] arr = new char[m][n];

            for (int i = 0; i < m; i++) {
                arr[i] = board[i].toCharArray();
            }

            while (true) {
                int count = remove(m, n, arr);
                if (count == 0) {
                    break;
                }

                answer += count;
                drop(m, n, arr);
            }

            return answer;
        }

        private void drop(int m, int n, char[][] arr) {
            for (int i = 0; i < n ; i++) {
                for (int j = m - 1; j > -1 ; j--) {
                    if (arr[j][i] == '-') {
                        for (int k = j - 1; k > -1 ; k--) {
                            if (arr[k][i] != '-') {
                                arr[j][i] = arr[k][i];
                                arr[k][i] = '-';
                                break;
                            }
                        }
                    }
                }
            }
        }

        private int remove(int m, int n, char[][] arr) {
            int count = 0;
            boolean[][] isRemoved = new boolean[m][n];

            for (int i = 0; i < m-1 ; i++) {
                for (int j = 0; j <n-1 ; j++) {
                    if(arr[i][j] != '-') {
                        removeCheck(arr, isRemoved, i, j);
                    }
                }
            }

            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n ; j++) {
                    if (isRemoved[i][j]) {
                        arr[i][j] = '-';
                        count++;
                    }
                }
            }

            return count;
        }

        private void removeCheck(char[][] arr, boolean[][] isRemoved, int x, int y) {
            char block = arr[x][y];

            for (int i = x; i < x + 2 ; i++) {
                for (int j = y; j < y + 2 ; j++) {
                    if (arr[i][j] != block) {
                        return;
                    }
                }
            }

            for (int i = x; i < x + 2 ; i++) {
                for (int j = y; j < y + 2 ; j++) {
                    isRemoved[i][j] = true;
                }
            }


        }
    }
}

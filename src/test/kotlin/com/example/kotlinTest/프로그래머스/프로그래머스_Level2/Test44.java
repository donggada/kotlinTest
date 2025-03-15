package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test44 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"O.X", ".O.", "..X"}
                )
        ).isEqualTo(
                1
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"OOO", "...", "XXX"}
                )
        ).isEqualTo(
                0
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"...", ".X.", "..."}
                )
        ).isEqualTo(
                0
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"...", "...", "..."}
                )
        ).isEqualTo(
                1
        );
    }


    class Solution {
        public int solution(String[] board) {

            int oCount = 0;
            int xCount = 0;

            for (String s : board) {
                for (char c : s.toCharArray()) {
                    if (c == 'O') {
                        oCount++;
                    }

                    if (c == 'X') {
                        xCount++;
                    }
                }
            }

            if (oCount < xCount) {
                return 0;
            }

            if (oCount > xCount +1) {
                return 0;
            }

            if (isFinish(board, 'O')) {
                if (oCount == xCount) {
                    return 0;
                }
            }

            if (isFinish(board, 'X')) {
                if (oCount == xCount + 1) {
                    return 0;
                }
            }


            return 1;
        }

        private boolean isFinish(String[] board, char target) {
            for (int i = 0; i < 3 ; i++) {
                if (board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target) {
                    return true;
                }
            }

            for (int i = 0; i < 3 ; i++) {
                if (board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target) {
                    return true;
                }
            }

            if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) ==target) {
                return true;
            }

            if (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) ==target) {
                return true;
            }

            return false;
        }
    }
}

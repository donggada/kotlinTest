

package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

public class Test30 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[][]{
                                {0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}
                        }
                )

        ).isEqualTo(
                9
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new int[][]{
                                {0,0,1,1},{1,1,1,1}
                        }
                )

        ).isEqualTo(
                4
        );
    }


    class Solution {
        public int solution(int [][] board) {
            int answer = 0;
            if (board.length == 1) {
                return 1;
            }
            for (int i = 1; i <board.length ; i++) {
                for (int j = 1; j <board[i].length ; j++) {
                    if (board[i][j] != 0) {
                        board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
                        answer = Math.max(board[i][j], answer);
                    }
                }
            }

            return answer * answer;
        }
    }
}
package com.example.kotlinTest.프로그래머스.프로그래머스_DFS_BFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test7 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(
                new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0}},
                new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}}
            )
        ).isEqualTo(14);

        Assertions.assertThat(
                solution.solution(
                        new int[][]{{0,0,0},{1,1,0},{1,1,1}},
                        new int[][]{{1,1,1},{1,0,0},{0,0,0}}
                )
        ).isEqualTo(0);

    }

    class Solution {
        public int solution(int[][] game_board, int[][] table) {
            int answer = -1;
            return answer;
        }
    }
}

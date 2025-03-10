package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Test41 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},3, 5
                )
        ).isEqualTo(
                7
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},5, 1
                )
        ).isEqualTo(
                11
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},1, 1
                )
        ).isEqualTo(
                12
        );
    }

    class Solution {
        public int solution(int[] players, int m, int k) {
            int severCount = 0;
            int currentServer = 0;

            // {time, severCount}
            LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i <players.length ; i++) {
                int player = players[i];

                while (!queue.isEmpty() && i == queue.peek()[0]) {
                    currentServer -= queue.pop()[1];
                }

                int needServer = player / m;
                int moreServer = currentServer - needServer;

                if (moreServer < 0) {
                    int absCount = Math.abs(moreServer);
                    currentServer += absCount;
                    severCount += absCount;
                    queue.add(new int[]{i + k, absCount});
                }
            }

            return severCount;
        }
    }
}

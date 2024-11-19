package com.example.kotlinTest.아정당;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {

    @Test
    void case1() {
        Assertions.assertThat(new Solution().solution(new int[][]{{1,2}, {3,4}})).isEqualTo(7);
    }

    @Test
    void case2() {
        Assertions.assertThat(new Solution().solution(new int[][]{{1,8,3,2}, {7,4,6,5}})).isEqualTo(19);
    }

    class Solution{

        static int[] dx = {1, 0};
        static int[] dy = {0, 1};

        static int answer = Integer.MAX_VALUE;
        static int R;
        static int C;
        static int[][] map;
        public int solution(int[][] grid) {
            R = grid.length;
            C = grid[0].length;
            map = grid;

            dfs(new int[]{0, 0, grid[0][0]});

            return answer;
        }

        private static void dfs(int[] move) {
            int x = move[0];
            int y = move[1];
            if (x == R -1 && y == C -1) {
                answer = Math.min(answer, move[2]);
                return;
            }

            for (int i = 0; i < 2 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < R && ny < C) {
                    dfs(new int[]{nx, ny, move[2] + map[nx][ny]});
                }
            }
        }
    }
}

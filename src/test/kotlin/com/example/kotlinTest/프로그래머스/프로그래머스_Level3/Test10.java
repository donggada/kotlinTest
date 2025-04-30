package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Test10 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}})
        ).isEqualTo(
                900
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}})
        ).isEqualTo(
                3800
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}})
        ).isEqualTo(
                2100
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}})
        ).isEqualTo(
                3200
        );
    }

    class Solution {
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        static boolean[][] visited;
        static int[][] costMap;
        static int x;
        static int y;
        public int solution(int[][] board) {
            x = board.length;
            y = board[0].length;
            visited = new boolean[x][y];
            costMap = new int[x][y];
            bfs(board);
            return costMap[x-1][y-1];
        }

        private void bfs(int[][] board) {
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, -1});

            while (!queue.isEmpty()) {
                int[] pop = queue.pop();
                int dir = pop[2];
                int cost = costMap[pop[0]][pop[1]];
                for (int i = 0; i < 4; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];
                    int nextCost = (dir == i || dir == -1) ? cost + 100 : cost + 600;

                    if (nx > -1 && nx < x && ny > -1 && ny < y && board[nx][ny] == 0) {
                        if (visited[nx][ny]) {
                            if (nextCost <= costMap[nx][ny]) {
                                queue.add(new int[]{nx, ny, i});
                                costMap[nx][ny] = nextCost;
                            }
                            continue;
                        }

                        queue.add(new int[]{nx, ny, i});
                        costMap[nx][ny] = nextCost;
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }
}

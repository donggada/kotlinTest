package com.example.kotlinTest.온다;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Test4 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution(new int[][]{
                        {1,1,0,1,1},
                        {0,1,1,0,0},
                        {0,0,0,0,0},
                        {1,1,0,1,1},
                        {1,0,1,1,1},
                        {1,0,1,1,1},
                })
        ).isEqualTo(new int[]{4,8});
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] board;
    static boolean[][] visited;
    static int maxAreaSize;
    class Solution {
        public int[] solution(int[][] v) {
            board = v;
            visited = new boolean[v.length][v[0].length];
            int whiteCount = 0;

            for (int i = 0; i < board.length ; i++) {
                for (int j = 0; j <board[i].length ; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        bfs(new int[]{i,j});
                        whiteCount++;
                    }
                }
            }

            return new int[]{whiteCount, maxAreaSize};
        }

        private void bfs(int[] move) {
            visited[move[0]][move[1]] = true;

            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(move);
            int areaSize = 1;

            while (!queue.isEmpty()) {
                int[] pop = queue.pop();
                for (int i = 0; i < 4; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    if (nx > -1 && ny > -1 && nx < board.length && ny < board[0].length) {
                        if (board[nx][ny] == 1 && !visited[nx][ny]) {
                            queue.add(new int[]{nx,ny});
                            visited[nx][ny] = true;
                            areaSize++;
                        }
                    }
                }
            }

            maxAreaSize = Math.max(maxAreaSize, areaSize);
        }
    }
}

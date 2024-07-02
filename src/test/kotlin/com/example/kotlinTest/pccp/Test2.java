package com.example.kotlinTest.pccp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Test2 {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}})
        ).isEqualTo(9);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}})
        ).isEqualTo(16);
    }

    class Solution {
        boolean[][] visited;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        static int count[];
        public int solution(int[][] land) {
            int answer = 0;

            //가로
            int n = land[0].length;

            //세로
            int m = land.length;

            count = new int[n];

            visited = new boolean[m][n];

            for (int col = 0; col < n ; col++) {
                int count = 0;
                for (int row = 0; row < m ; row++) {
                    if(land[row][col] == 1 && !visited[row][col]) {
                        bfs(new int[]{row, col}, land);
                    }
                }
            }

            Arrays.sort(count);

            return count[n-1];
        }

        private void bfs(int[] move, int[][] land) {
            boolean[] rowCount = new boolean[land[0].length];
            visited[move[0]][move[1]] = true;
            rowCount[move[1]] = true;
            int result = 1;
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(move);

            while (!queue.isEmpty()) {
                int[] pop = queue.pop();

                for (int i = 0; i < 4 ; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    if (nx < visited.length && nx > -1 && ny > -1 && ny < visited[0].length) {
                        if (land[nx][ny] == 1 && !visited[nx][ny]) {
                            result++;
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            rowCount[ny] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < rowCount.length ; i++) {
                if (rowCount[i]) {
                    count[i] += result;
                }
            }
        }
    }
}

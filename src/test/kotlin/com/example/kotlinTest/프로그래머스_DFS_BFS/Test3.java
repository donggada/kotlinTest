package com.example.kotlinTest.프로그래머스_DFS_BFS;

import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(
                new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}})
            ).isEqualTo(11);

        Assertions.assertThat(
            solution.solution(
                new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})
        ).isEqualTo(-1);


    }

    class Solution {
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static boolean[][] visited;
        static LinkedList<int[]> queue;
        public int solution(int[][] maps) {
            int col = maps.length;
            int row = maps[0].length;

            visited = new boolean[col][row];
            queue = new LinkedList<>();
            queue.add(new int[]{0,0});

            bfs(0, 0, maps);

            if (visited[col - 1][row - 1] == false) {
                return -1;
            }

            return maps[col -1][row -1];
        }

        public static void bfs(int x, int y, int[][] maps) {
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                int[] cur_info = queue.pop();
                int curX = cur_info[0];
                int curY = cur_info[1];

                for (int i = 0; i < 4 ; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if (nextX > -1 && nextX < maps.length && nextY > -1 && nextY < maps[0].length && maps[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        maps[nextX][nextY] += maps[curX][curY];
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }

        }
    }
}



package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Test26 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                      new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}
                )
        ).isEqualTo(
                16
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}
                )
        ).isEqualTo(
                -1
        );
    }



    class Solution {
        static char[][] map;
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        public int solution(String[] maps) {
            int x = maps.length;
            int y = maps[0].length();
            map = new char[x][y];
            int[] start = {};
            int[] lever = {};
            int[] end = {};

            for (int i = 0; i <x ; i++) {
                for (int j = 0; j < y ; j++) {
                    char c = maps[i].charAt(j);

                    if (c == 'S') {
                        start = new int[]{i, j ,0};
                    }

                    if (c == 'L') {
                        lever = new int[]{i, j ,0};
                    }

                    if (c == 'E') {
                        end = new int[]{i, j};
                    }

                    map[i][j] = c;
                }
            }

            int startBfs = bfs(start, lever);
            int endBfs = bfs(lever, end);

            if (startBfs == -1 || endBfs == -1) {
                return -1;
            }

            return startBfs + endBfs;
        }

        private int bfs(int[] startMove, int[] endMove) {
            int xLength = map.length;
            int yLength = map[0].length;
            boolean[][] visited = new boolean[xLength][yLength];
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(startMove);

            visited[startMove[0]][startMove[1]] = true;

            while (!queue.isEmpty()) {
                int[] pop = queue.pop();

                for (int i = 0; i < 4 ; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    if (endMove[0] == nx && endMove[1] == ny) {
                        return pop[2] + 1;
                    }

                    if (nx > -1 && nx < xLength && ny > -1 && ny < yLength) {
                        if (!visited[nx][ny] && map[nx][ny] != 'X') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, pop[2] + 1});
                        }
                    }
                }
            }

            return -1;
        }
    }

}
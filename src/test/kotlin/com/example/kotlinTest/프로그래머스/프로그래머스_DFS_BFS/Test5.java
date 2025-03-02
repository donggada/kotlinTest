package com.example.kotlinTest.프로그래머스.프로그래머스_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test5 {

    @Test
    void  test() {
        Solution solution = new Solution();
        Assertions.assertThat(
            solution.solution(
                new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8)
        ).isEqualTo(17);

        Assertions.assertThat(
            solution.solution(
                new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}, 9,	7,	6,	1)
        ).isEqualTo(11);

        Assertions.assertThat(
            solution.solution(
                new int[][]{{1,1,5,7}}, 1, 1, 4, 7)
        ).isEqualTo(9);

        Assertions.assertThat(
            solution.solution(
                new int[][]{{2,1,7,5},{6,4,10,10}}, 3, 1, 7, 10)
        ).isEqualTo(15);

        Assertions.assertThat(
            solution.solution(
                new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}}, 1, 4, 6, 3)
        ).isEqualTo(10);



    }

    class Solution {
        static int[] dI = {0, 0, 1, -1};
        static int[] dJ = {1, -1, 0, 0};
        static boolean[][] visited;
        static int[][] map;
        Queue<int[]> queue;

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX,
            int itemY) {
            map = new int[101][101];
            visited = new boolean[101][101];
            queue = new LinkedList<>();

            for (int[] rect : rectangle) {
                int startI = rect[1] * 2;
                int endI = rect[3] * 2;

                int startJ = rect[0] * 2;
                int endJ = rect[2] * 2;

                for (int i = startI; i <= endI; i++) {
                    for (int j = startJ; j <= endJ; j++) {
                        if (i == startI || i == endI || j == startJ || j == endJ) {
                            if (map[i][j] == 2) {
                                continue;
                            }
                            map[i][j] = 1;
                        } else {
                            map[i][j] = 2;
                        }
                    }

                }
            }

            bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

            return map[itemY * 2][itemX * 2] / 2;
        }

        static void bfs(int characterX, int characterY, int itemX, int itemY) {
            visited[characterY][characterX] = true;

            if (characterY == itemY && characterX == itemX) {
                return;
            }

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{characterY, characterX});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentI = current[0];
                int currentJ = current[1];


                for (int i = 0; i < 4; i++) {
                    int nextI = currentI + dI[i];
                    int nextJ = currentJ + dJ[i];

                    if (nextI > -1 && nextI < 101 && nextJ > -1 && nextJ < 101) {
                        if (!visited[nextI][nextJ] && map[nextI][nextJ] == 1) {
                            queue.add(new int[]{nextI, nextJ});
                            map[nextI][nextJ] += map[currentI][currentJ];
                        }
                    }

                }
            }

        }


    }
}

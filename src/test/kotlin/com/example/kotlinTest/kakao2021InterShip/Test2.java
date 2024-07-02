package com.example.kotlinTest.kakao2021InterShip;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Test2 {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(
                        new String[][]{
                                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
                                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" }
                        }

                )
        ).isEqualTo(
                new int[]{1, 0, 1, 1, 1}
        );
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(
                        new String[][]{
                                {"OOOXP", "OXXPO", "OXXOX", "OOXOX", "XXXXX"},
                        }

                )
        ).isEqualTo(
                new int[]{0}
        );
    }

    class Solution {

        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};

        public int[] solution(String[][] places) {
            int n = places.length;
            int[] answer = new int[n];

            LinkedList<int[]> quque = new LinkedList<>();

            for (int i = 0; i < n ; i++) {
                String[] place = places[i];
                boolean isPossible = true;

                for (int j = 0; j < 5 ; j++) {
                    for (int k = 0; k < 5 ; k++) {
                        if (!isPossible) {
                            continue;
                        }

                        if (place[j].charAt(k) == 'P') {
                            quque.add(new int[]{j ,k});
                            boolean[][] visited = new boolean[5][5];
                            visited[j][k] = true;
                            while (!quque.isEmpty()) {
                                int[] pop = quque.pop();

                                for (int l = 0; l < 4 ; l++) {
                                    int nx = pop[0] + dx[l];
                                    int ny = pop[1] + dy[l];

                                    if (nx > -1 && ny > -1 && nx < 5 && ny < 5) {
                                        if (!visited[nx][ny]) {
                                            int size = Math.abs(nx - j) + Math.abs(ny - k);

                                            if (place[nx].charAt(ny) == 'O' && size < 3) {
                                                quque.add(new int[]{nx, ny});
                                                visited[nx][ny] = true;
                                            }

                                            if (place[nx].charAt(ny) == 'P'&& size < 3) {
                                                isPossible = false;
                                            }
                                        }

                                    }
                                }

                            }

                        }

                    }
                }

                if (isPossible) {
                    answer[i] = 1;
                }
            }

            return answer;
        }
    }
}

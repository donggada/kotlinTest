package com.example.kotlinTest.프로그래머스_Level2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Test38 {

    Solution solution = new Solution();

    @Test
    void case1() {
        assertThat(solution.solution(
                        new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"},
                        new String[]{"A", "BB", "A"}
                )
        ).isEqualTo(
                11
        );
    }

    @Test
    void case2() {
        assertThat(solution.solution(
                new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"},
                new String[]{"C", "B", "B", "B", "B", "H"}
                )
        ).isEqualTo(
                4
        );
    }



    class Solution {
        static String[][] map;
        static boolean[][] memoMap;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static int lenX;
        static int lenY;
        static final int INF = 10001;

        public int solution(String[] storage, String[] requests) {
            int answer = 0;
            lenX = storage.length;
            lenY = storage[0].length();
            map = new String[lenX][lenY];
            memoMap = new boolean[lenX][lenY];

            for (int i = 0; i < lenX; i++) {
                map[i] = storage[i].split("");
            }

            for (String req : requests) {
                int length = req.length();
                if (length == 2) {
                    useCrane(req.substring(0, 1));
                    continue;
                }

                int[][] memo = new int[lenX][lenY];
                for (int i = 0; i < lenX; i++) {
                    Arrays.fill(memo[i], INF);
                }

                List<int[]> list = new ArrayList<>();
                LinkedList<int[]> queue = new LinkedList<>();
                for (int i = 0; i < lenX; i++) {
                    for (int j = 0; j < lenY; j++) {
                        if (i != 0 && j != 0 && i != lenX - 1 && j != lenY - 1) {
                            continue;
                        }

                        if (memo[i][j] != INF) {
                            continue;
                        }

                        if (!map[i][j].isEmpty()) {
                            memo[i][j] = 1;
                            if (map[i][j].equals(req)) {
                                list.add(new int[]{i, j});
                            }
                            continue;
                        }
                        memo[i][j] = 0;
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] pop = queue.pop();
                            for (int k = 0; k < 4; k++) {
                                int nx = pop[0] + dx[k];
                                int ny = pop[1] + dy[k];

                                if (!check(nx, ny) || memo[nx][ny] != INF) {
                                    continue;
                                }

                                if (map[nx][ny].isEmpty()) {
                                    memo[nx][ny] = 0;
                                    queue.add(new int[]{nx, ny});
                                    continue;
                                }
                                memo[nx][ny] = 1;

                                if (map[nx][ny].equals(req)) {
                                    list.add(new int[]{nx, ny});
                                }
                            }
                        }

                    }
                }
                for (int[] arr : list) {
                    map[arr[0]][arr[1]] = "";
                }

            }

            for (int i = 0; i < lenX; i++) {
                for (int j = 0; j < lenY; j++) {
                    if (!map[i][j].isEmpty()) {
                        answer++;
                    }
                }
            }

            return answer;
        }


        private void useCrane(String target) {
            for (int i = 0; i < lenX; i++) {
                for (int j = 0; j < lenY; j++) {
                    if (map[i][j].equals(target)) {
                        map[i][j] = "";
                    }
                }
            }
        }

        private boolean check(int x, int y) {
            return x > -1 && x < lenX && y > -1 && y < lenY;
        }
    }
}

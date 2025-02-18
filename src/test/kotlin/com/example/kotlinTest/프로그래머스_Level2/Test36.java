package com.example.kotlinTest.프로그래머스_Level2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Test36 {

    Solution solution = new Solution();

    @Test
    void case1() {
        assertThat(solution.solution(
                        new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}
                )
        ).isEqualTo(
                new String[]{"....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"}
        );
    }

    @Test
    void case2() {
        assertThat(solution.solution(
                        new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}
                )
        ).isEqualTo(
                new String[]{"*.*"}
        );
    }

    @Test
    void case3() {
        assertThat(solution.solution(
                        new int[][]{{1, -1, 0}, {2, -1, 0}}
                )
        ).isEqualTo(
                new String[]{"*"}
        );
    }

    @Test
    void case4() {
        assertThat(solution.solution(
                        new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1,0}}
                )
        ).isEqualTo(
                new String[]{"*"}
        );
    }

    class Solution {
        public String[] solution(int[][] line) {
            ArrayList<long[]> intersectionList = new ArrayList<>();
            long maxX = Integer.MIN_VALUE;
            long maxY = Integer.MIN_VALUE;
            long minX = Integer.MAX_VALUE;
            long minY = Integer.MAX_VALUE;

            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    long[] intersection = findIntersection(
                            new long[]{line[i][0],line[i][1],line[i][2]},
                            new long[]{line[j][0],line[j][1],line[j][2]}
                    );
                    if (intersection.length == 0) {
                        continue;
                    }
                    maxX = Math.max(maxX, intersection[0]);
                    minX = Math.min(minX, intersection[0]);
                    maxY = Math.max(maxY, intersection[1]);
                    minY = Math.min(minY, intersection[1]);
                    intersectionList.add(intersection);
                }
            }

            long xLength = maxX - minX + 1;
            long yLength = maxY - minY + 1;

            char[][] map = new char[(int) yLength][(int) xLength];

            for(int i = 0; i < yLength; i++) {
                for(int j = 0; j < xLength; j++) {
                    map[i][j] = '.';
                }
            }

            for (long[] intersection : intersectionList) {
                int x = (int) (intersection[0] - minX);
                int y = (int) (maxY - intersection[1]);
                map[y][x] = '*';
            }



            String[] answer = new String[map.length];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = new String(map[i]);
            }

            return answer;
        }

        private long[] findIntersection(long[] equation1, long[] equation2) {
            long x1 = equation1[0];
            long y1 = equation1[1];
            long m1 = equation1[2];

            long x2 = equation2[0];
            long y2 = equation2[1];
            long m2 = equation2[2];


            double x = (double) (y1 * m2 - m1 * y2) / (x1 * y2 - y1 * x2);
            double y = (double) (m1 * x2 - x1 * m2) / (x1 * y2 - y1 * x2);

            if ((x1 * y2 - y1 * x2) != 0) {
                if (x % 1 == 0  && y % 1 == 0) {
                    return new long[]{(long) x, (long)y};
                }
            }

            return new long[]{};
        }
    }
}

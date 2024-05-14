package com.example.kotlinTest.kakao_2017;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Test1 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                        6, 4,
                        new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}
                )
        ).isEqualTo(new int[]{4,5});
    }



    class Solution {
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        static int M;
        static int N;
        static int[][] map;
        static boolean[][] visted;
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            map = picture;
            M = m;
            N = n;
            visted = new boolean[m][n];

            for (int i = 0; i <M ; i++) {
                for (int j = 0; j < N ; j++) {
                    if (!visted[i][j] && map[i][j] != 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(new int[]{i,j}, map[i][j]));
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        private int bfs(int [] move, int val) {
            int count = 1;

            LinkedList<int[]> queue = new LinkedList<>();
            visted[move[0]][move[1]] = true;

            queue.add(move);

            while (!queue.isEmpty()){
                int[] pop = queue.pop();


                for (int i = 0; i < 4 ; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    if (nx > -1 && ny > -1 && nx < M && ny < N) {
                        if (!visted[nx][ny] &&  map[nx][ny] == val) {
                            queue.add(new int[]{nx, ny});
                            visted[nx][ny] = true;
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }

}

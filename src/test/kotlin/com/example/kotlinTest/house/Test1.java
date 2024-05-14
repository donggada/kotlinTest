package com.example.kotlinTest.house;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Test1 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                      new String[][] {{"W", "W", "B"} , {"W", "B", "W"}, {"B", "W", "W"}}
           )
        ).isEqualTo(3);

        Assertions.assertThat(
                solution.solution(
                        new String[][] {{"B", "B", "W"} , {"B", "B", "W"}, {"B", "W", "W"}}
                )
        ).isEqualTo(0);
    }

    class Solution {
        static boolean[][] visited;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        static int count;
        public int solution(String[][] arr) {
            int answer = 0;

            return answer;
        }

        private static void bfs(int[] move, String[][] arr) {
            visited[move[0]][move[1]] = true;


            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(move);

            while (!queue.isEmpty()) {
                int[] pop = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    if (nx > -1 && ny > -1 && nx < arr.length && ny < arr[0].length) {
                        if (!visited[nx][ny] && arr[nx][ny].equals("B")) {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            count++;
        }
    }
}



package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Test27 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                      new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}
                )
        ).isEqualTo(
                7
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{".D.R", "....", ".G..", "...D"}
                )
        ).isEqualTo(
                -1
        );
    }



    class Solution {
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        static char[][] arr;
        static boolean[][] visited;
        public int solution(String[] board) {
            arr = new char[board.length][board[0].length()];
            visited = new boolean[board.length][board[0].length()];
            int[] start ={};
            int[] end ={};
            for (int i = 0; i < board.length ; i++) {
                for (int j = 0; j <board[i].length() ; j++) {
                    char c = board[i].charAt(j);

                    if (c == 'R') {
                        start = new int[]{i, j, 0};
                    }

                    if (c == 'G') {
                        end = new int[]{i, j};
                    }

                    arr[i][j] = c;
                }
            }

            return bfs(start, end);
        }

        private int bfs(int[] start, int[] end){
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(start);
            visited[start[0]][start[1]] = true;
            while (!queue.isEmpty()) {
                int[] pop = queue.pop();

                if (end[0] == pop[0] && end[1] == pop[1]) {
                    return pop[2];
                }

                for (int i = 0; i < 4 ; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    while (nx > -1 && nx < arr.length && ny > -1 && ny < arr[0].length && arr[nx][ny] != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    }

                    nx -= dx[i];
                    ny -= dy[i];

                    if (!visited[nx][ny] && (pop[0] != nx || pop[1] != ny)) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, pop[2]+1});
                    }
                }

            }

            return -1;
        }

    }

}
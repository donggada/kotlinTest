package com.example.kotlinTest.아정당;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Test4 {

    @Test
    void case1() {
        Assertions.assertThat(new Solution().solution(
               new String[][]{
                       {"A", "B", "T", "T", "T"}, {"T", "C", "D", "E", "T"}, {"T", "T", "T", "F", "T"}, {"B", "A", "H", "G", "F"}, {"C", "D", "E", "F", "G"}
               }
        )).isEqualTo("15");
    }



    class Solution {
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        static boolean[][] visited;
        static int answer = Integer.MIN_VALUE;
        public int solution(String[][] board) {
            visited = new boolean[board.length][board[0].length];
            System.out.println("B".compareTo("A"));
            for (int i = 0; i < board.length ; i++) {
                for (int j = 0; j <board[i].length ; j++) {
                    dfs(new int[]{i, j, 1}, board[i][j], board, true, board[i][j]);
                }
            }

            return answer;
        }

        private static void dfs(int[] move, String beforeSt, String[][] board, boolean flag, String s) {
            int x = move[0];
            int y = move[1];

            for (int i = 0; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > -1 && ny > -1  && nx < board.length && ny < board[0].length) {
                    if (!visited[nx][ny]) {
                        if (board[nx][ny].compareTo(beforeSt) == 1) {
                            visited[nx][ny] = true;
                            dfs(new int[]{nx, ny, move[2] +1}, board[nx][ny], board, flag, s + board[nx][ny]);
                            visited[nx][ny] = false;
                        }

                        if (board[nx][ny].compareTo(beforeSt) == -1 && flag) {
                            visited[nx][ny] = true;
                            dfs(new int[]{nx, ny, move[2] +1}, board[nx][ny], board, false,  s + board[nx][ny]);
                            visited[nx][ny] = false;
                        }
                    }

                    if (move[2] == 10) {
                        System.out.println();
                    }
                    answer = Math.max(answer, move[2]);
                }
            }

        }

    }
}



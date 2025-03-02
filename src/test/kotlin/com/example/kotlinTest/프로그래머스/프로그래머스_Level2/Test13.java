
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Test13 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"X591X","X1X5X","X231X", "1XXX1"}
                )
        ).isEqualTo(
                new int[]{1, 1, 27}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"XXX","XXX","XXX"}
                )
        ).isEqualTo(
                new int[]{-1}
        );
    }

    class Solution {
        static int[] dx = {1,-1, 0, 0};
        static int[] dy = {0,0, 1, -1};
        static boolean[][] visited;
        static char[][] arr;
        public int[] solution(String[] maps) {
            int[] answer = {};
            int xLen = maps.length;
            int yLen = maps[0].length();

            visited = new boolean[xLen][yLen];
            arr = new char[xLen][yLen];
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < xLen ; i++) {
                for (int j = 0; j < yLen ; j++) {
                    arr[i][j] = maps[i].charAt(j);
                }
            }
            for (int i = 0; i < xLen ; i++) {
                for (int j = 0; j < yLen ; j++) {
                    if (!visited[i][j] && arr[i][j] != 'X') {
//                        result.add(bfs(new int[]{i, j, arr[i][j]}));
                        result.add(dfs(new int[]{i, j, arr[i][j]}));
                    }
                }
            }

            if (result.isEmpty()) {
                return new int[]{-1};
            }

            Collections.sort(result);
            answer = new int[result.size()];

            for (int i = 0; i < result.size() ; i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }

        private int bfs (int[] move) {
            visited[move[0]][move[1]] = true;
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(move);
            int val = move[2] - '0';

            while (!queue.isEmpty()) {
                int[] pop = queue.pop();

                for (int i = 0; i < 4 ; i++) {
                    int nx = pop[0] + dx[i];
                    int ny = pop[1] + dy[i];

                    if (nx > -1 && nx < arr.length && ny > -1 && ny < arr[0].length) {
                        if (!visited[nx][ny] && arr[nx][ny] != 'X') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx,ny});
                            val += arr[nx][ny] - '0';
                        }
                    }
                }
            }
            return val;
        }

        private int dfs(int[] move) {
            visited[move[0]][move[1]] = true;
            int val = 0;
            for (int i = 0; i < 4 ; i++) {
                int nx = move[0] + dx[i];
                int ny = move[1] + dy[i];

                if (nx > -1 && nx < arr.length && ny > -1 && ny < arr[0].length) {
                    if (!visited[nx][ny] && arr[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        val += dfs(new int[]{nx, ny, arr[nx][ny] - '0'});
                    }
                }
            }

            return val + arr[move[0]][move[1]] - '0';
        }
    }

}
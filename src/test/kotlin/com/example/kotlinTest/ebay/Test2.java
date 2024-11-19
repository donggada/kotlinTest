package com.example.kotlinTest.ebay;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Test2 {


    @Test
    void case1() {

        Assertions.assertThat(new Solution().solution(
                5, new int[]{9 ,3, 9, 9, 9, 5, 2, 7, 8, 9, 8, 1, 5, 8, 9, 6, 1, 8, 7, 9, 9, 9, 8, 9, 9}
        )).isEqualTo(13);

    }


    class Solution {
        static int[] dx = {1, -1 ,0, 0};
        static int[] dy = {0, 0 ,1, -1};

        public int solution(int N, int[] board) {
            int minNum = Integer.MAX_VALUE;
            int start = (N - 1) / 2;
            boolean[][]noRoadMap = new boolean[N][N];
            int[][] map = new int[N][N];

            LinkedList<Node> queue = new LinkedList<>();

            for (int i = 0; i < board.length ; i++) {
                if (i / N == i % N) {
                    noRoadMap[i / N][i % N] = true;
                }

                map[i / N][i % N] = board[i];
            }

            queue.add(new Node(start, start, map[start][start], new HashSet<>()));


            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int mx = node.x;
                int my = node.y;
                int sum = node.sum;
                Set<String> visited = node.visited;


                if (mx == 0 || my == 0 || mx == N-1 || my == N-1) {
                    minNum = Math.min(sum, minNum);
                    continue;
                }

                for (int i = 0; i < 4 ; i++) {
                    int nx = mx + dx[i];
                    int ny = my + dy[i];
                    String visitedString = nx + "," + ny;

                    if (nx > -1 && ny > -1 && nx < N && ny < N ) {
                        if (!noRoadMap[nx][ny] && !visited.contains(visitedString)) {
                            Set<String> newVisited = new HashSet<>(visited);
                            newVisited.add(visitedString);
                            queue.add(new Node(nx, ny, sum + map[nx][ny], newVisited));
                        }
                    }
                }

            }
            return minNum;
        }

        class Node {
            int x;
            int y;
            int sum;
            Set<String> visited;

            Node(int x, int y, int currentSum, Set<String> visited) {
                this.x = x;
                this.y = y;
                this.sum = currentSum;
                this.visited = visited;
            }
        }
    }
}

package com.example.kotlinTest.kakao_2023_blind_recruitment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2_미로탈출명령어 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(3, 4, 2, 3, 3, 1, 5)
        ).isEqualTo(
                "dllrl"
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(2, 2, 1, 1, 2, 2, 2)
        ).isEqualTo(
                "dr"
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(3, 3, 1, 2, 3, 3, 4)
        ).isEqualTo(
                "impossible"
        );
    }

    class Solution {
        static int[] dx = {1, 0, 0, -1};
        static int[] dy = {0, -1, 1, 0};
        static String[] roads = {"d", "l", "r", "u"};
        static int[][] visited;
        static String answer;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            answer = "impossible";
            visited = new int[n][m];
            int distance = distance(x, y, r, c);
            if ((k - distance) % 2 == 1 || k < distance) {
                return answer;
            }
            dfs(new Node(x - 1, y - 1, "", 0), n, m, r - 1, c - 1, k);
            return answer;
        }

        private void dfs(Node node, int n, int m, int r, int c, int k) {
            if (node.count + distance(node.x, node.y, r, c) > k) {
                return;
            }

            if (node.count == k) {
                if (node.x == r && node.y == c) {
                    if (answer.equals("impossible")) {
                        answer = node.road;
                        return;
                    }

                    if (answer.compareTo(node.road) > 0) {
                        answer = node.road;
                    }
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx > -1 && nx < n && ny > -1 && ny < m) {
                    if (visited[nx][ny] < 2) {
                        visited[nx][ny]++;
                        dfs(new Node(nx, ny, node.road + roads[i], node.count + 1), n, m, r, c, k);
                        visited[nx][ny]--;
                    }
                }
            }
        }

        private int distance(int x, int y, int r, int c){
            return (int)Math.abs(x-r) + (int)Math.abs(y-c);
        }



        public class Node {
            int x;
            int y;
            String road;
            int count;

            public Node(int x, int y, String road, int count) {
                this.x = x;
                this.y = y;
                this.road = road;
                this.count = count;
            }
        }
    }

}

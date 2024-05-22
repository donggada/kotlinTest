package com.example.kotlinTest.kakao2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                        6, 4, 6, 2,
                        new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
                        }
                )
        ).isEqualTo(82);

        Assertions.assertThat(
                solution.solution(
                        7, 3, 4, 1,
                        new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}
                )
        ).isEqualTo(14);

        Assertions.assertThat(
                solution.solution(
                        6, 4, 5, 6,
                        new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}
                )
        ).isEqualTo(18);
    }



    class Solution {
        static int[] result;
        static boolean[] visited;
        static List<Node>[] nodes;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            result = new int[n + 1];
            visited = new boolean[n + 1];
            nodes = new List[n +1];

            for (int i = 0; i < n + 1 ; i++) {
                nodes[i] = new ArrayList<>();
                result[i] = Integer.MAX_VALUE;
            }

            for (int[] fare :fares) {
                nodes[fare[0]].add(new Node(fare[1], fare[2]));
                nodes[fare[1]].add(new Node(fare[0], fare[2]));
            }


            dij(s);

            int sToa = result[a];
            int sTob = result[b];

            result = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < n + 1 ; i++) {
                result[i] = Integer.MAX_VALUE;
            }

            dij(a);

            int result1 = sToa + result[b];

            result = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < n + 1 ; i++) {
                result[i] = Integer.MAX_VALUE;
            }

            dij(b);

            int result2 = sTob + result[a];



            return Math.min(result1, result2);
        }

        private void dij(int start) {
            PriorityQueue<Node> queue = new PriorityQueue<>();
            result[start] = 0;

            queue.add(new Node(start, 0));

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                visited[cur.end] = true;

                for (Node node : nodes[cur.end]) {
                    if (!visited[node.end]) {
                        if (result[cur.end] + node.val < result[node.end]) {
                            result[node.end] = result[cur.end] + node.val;
                            queue.add(new Node(node.end, result[node.end]));
                        }
                    }
                }

            }

        }
    }

    public static class Node implements Comparable<Node> {
        public int end;
        public int val;
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }

        public Node(int end, int val) {
            this.end = end;
            this.val = val;
        }
    }



}

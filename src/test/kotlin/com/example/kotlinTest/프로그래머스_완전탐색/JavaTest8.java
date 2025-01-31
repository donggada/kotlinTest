package com.example.kotlinTest.프로그래머스_완전탐색;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaTest8 {
    Solution solution = new Solution();


    @Test
    void case1() {
        assertThat(
            solution.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})
        ).isEqualTo(
            3
        );
    }

    @Test
    void case2() {
        assertThat(
            solution.solution(4, new int[][]{{1,2},{2,3},{3,4}})
        ).isEqualTo(
            0
        );
    }

    @Test
    void case3() {
        assertThat(
            solution.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}})
        ).isEqualTo(
            1
        );
    }

    class Solution {
        static int count;
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            HashMap<Integer, List<Integer>> node = new HashMap<>();

            for (int[] wire :wires) {
                int key1 = wire[0];
                List<Integer> list1 = node.getOrDefault(key1, new ArrayList<>());
                list1.add(wire[1]);
                node.put(key1, list1);

                int key2 = wire[1];
                List<Integer> list2 = node.getOrDefault(key2, new ArrayList<>());
                list2.add(wire[0]);
                node.put(key2, list2);
            }

            for (int[] wire :wires) {
                node.get(wire[0]).remove((Integer) wire[1]);
                node.get(wire[1]).remove((Integer) wire[0]);
                boolean[] visited = new boolean[n+1];

                int count = bfs(1, node, visited);

                answer = Math.min(answer, Math.abs(count - (n - count)));

                node.get(wire[0]).add(wire[1]);
                node.get(wire[1]).add(wire[0]);
            }

            return answer;
        }

        private int bfs(int node, HashMap<Integer, List<Integer>> map, boolean[] visited) {
            visited[node] = true;
            int count = 1;

            for (int nextNode : map.getOrDefault(node, new ArrayList<>())) {
                if (!visited[nextNode]) {
                   count += bfs(nextNode, map, visited);
                }
            }

            return count;
        }
    }

}

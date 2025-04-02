package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test8 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(3, new int[][]{{1,2}, {2,3}}, new int[]{2,3}, 1)
        ).isEqualTo(
            new int[]{1,2}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1,3,5}, 5)
        ).isEqualTo(
                new int[]{2,-1,0}
        );
    }



    class Solution {
        static HashMap<Integer, ArrayList<Integer>> map;
        static int[] dp;
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            map = new HashMap<>();
            dp = new int[n+1];
            for (int[] road : roads) {
                ArrayList<Integer> list1 = map.getOrDefault(road[0], new ArrayList<>());
                list1.add(road[1]);
                map.put(road[0], list1);

                ArrayList<Integer> list2 = map.getOrDefault(road[1], new ArrayList<>());
                list2.add(road[0]);
                map.put(road[1], list2);
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            bfs(destination);

            for (int i = 0; i < sources.length ; i++) {
                answer[i] = dp[sources[i]] == Integer.MAX_VALUE ? -1 : dp[sources[i]];
            }

            return answer;
        }

        private void bfs(int destination) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(destination);
            dp[destination] = 0;

            while (!queue.isEmpty()) {
                int node = queue.pop();

                for (int nextNode : map.getOrDefault(node, new ArrayList<>())) {
                    if (dp[nextNode] > dp[node] + 1) {
                        dp[nextNode] = dp[node] + 1;
                        queue.add(nextNode);
                    }
                }
            }
        }
    }
}

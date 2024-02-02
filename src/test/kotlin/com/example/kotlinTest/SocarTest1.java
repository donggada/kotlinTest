package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest14.Solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SocarTest1 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(6, 17, new int[][]{{5,4,6}, {5,2,5}, {0,4,2}, {2,3,3}, {1,2,7}, {0,1,3}})
        ).isEqualTo(new int[]{1,2,3});

        Assertions.assertThat(
            solution.solution(4, 10, new int[][]{{0,1,2}, {0,2,3}})
        ).isEqualTo(new int[]{0,1});

        Assertions.assertThat(
            solution.solution(4, 11, new int[][]{{0,1,2}, {1,2,7}, {2,3,10}, {3,0,9}})
        ).isEqualTo(new int[]{-1});

    }

    class Solution {
        static Set<Integer> nodeSet;
        public int[] solution(int n ,int k, int[][] roads) {
            int [][] arr = new int[n][n];
            nodeSet = new HashSet<>();
            for (int [] road : roads) {
                int startRoad = road[0];
                int endRoad = road[1];
                int time = road[2];
                arr[startRoad][endRoad] = time;
                arr[endRoad][startRoad] = time;
            }

            dfs(0, 0, k ,arr);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                if (nodeSet.contains(i)) {
                    list.add(i);
                }
            }
            if (list.isEmpty()) {
                return new int[]{-1};
            }

            Collections.sort(list);

            int[] answer = new int[list.size()];
            for (int i = 0; i <list.size() ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }

        private void dfs(int node, int sum, int k, int[][] arr) {
            if (sum == k) {
                nodeSet.add(node);
                return;
            }
            if (sum > k) {
                return;
            }
            for (int i = 0; i <arr.length ; i++) {
                if (node == i) {
                    continue;
                }
                int next = arr[node][i];
                int back = arr[i][node];

                if (next != 0 && back != 0) {
                    dfs(i, sum+ next, k, arr);
                    dfs(i,  sum + back, k, arr);
                }
            }
        }
    }
}

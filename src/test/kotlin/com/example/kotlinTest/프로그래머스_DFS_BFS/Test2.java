package com.example.kotlinTest.프로그래머스_DFS_BFS;

import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(
                3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})
            ).isEqualTo(2);

        Assertions.assertThat(
            solution.solution(
               3,new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})
        ).isEqualTo(1);


    }

    class Solution {
        static int [][] arr;
        static HashSet<Integer> visitNode;
        public int solution(int n, int[][] computers) {
            int answer = 0;
            arr = computers;
            visitNode = new HashSet<>();

            for (int i = 0; i < n; i++) {
                if (!visitNode.contains(i)) {
                    dfs(i);
                    answer++;
                }
            }

            return answer;
        }

        private static void dfs (int node) {
            if (visitNode.contains(node)) {
                return;
            }

            visitNode.add(node);

            for (int i = 0; i < arr[node].length ; i++) {
                if (!visitNode.contains(i) && arr[node][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}

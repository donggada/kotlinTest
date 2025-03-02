package com.example.kotlinTest.프로그래머스.프로그래머스_DFS_BFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(
                new int[] {1, 1, 1, 1, 1}, 3)
            ).isEqualTo(5);

        Assertions.assertThat(
            solution.solution(
                new int[] {4, 1, 2, 1}, 4)
        ).isEqualTo(2);


    }

    class Solution {
        static int count;
        static int[] arr;
        static int targetSum;
        public int solution(int[] numbers, int target) {
            count = 0;
            arr = numbers;
            targetSum = target;
            dfs(0, 0);
            return count;
        }

        private static void dfs (int node, int sum) {
            if (node == arr.length) {
                if (sum == targetSum) {
                    count++;
                }
                return;
            }
            int nextNode = node + 1;
            dfs(nextNode, sum + arr[node]);
            dfs(nextNode, sum - arr[node]);
        }
    }
}

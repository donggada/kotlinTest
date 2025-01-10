package com.example.kotlinTest.프로그래머스_탐욕법;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Test4 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})
        ).isEqualTo(
                4
        );
    }



    class Solution {
        int[] nodeArray;
        public int solution(int n, int[][] costs) {
            int answer =  0;
            nodeArray = new int[n];

            for (int i = 0; i < n ; i++) {
                nodeArray[i] = i;
            }

            Arrays.sort(costs, Comparator.comparingInt(arr -> arr[2]));

            for (int[] cost : costs) {
                int startNode = cost[0];
                int endNode = cost[1];
                if (findParentNode(startNode) != findParentNode(endNode)) {
                    unionNode(startNode, endNode);
                    answer += cost[2];
                }
            }

            return answer;
        }

        private int findParentNode(int node) {
            if (nodeArray[node] == node) {
                return node;
            }

            return findParentNode(nodeArray[node]);
        }

        private void unionNode(int node1, int node2) {
            int startNodeParent = findParentNode(node1);
            int endNodeParent = findParentNode(node2);
            nodeArray[startNodeParent] = endNodeParent;
        }

    }
}

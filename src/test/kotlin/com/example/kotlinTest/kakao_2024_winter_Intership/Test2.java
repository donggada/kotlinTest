package com.example.kotlinTest.kakao_2024_winter_Intership;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.notIn;

public class Test2 {
    @Test
    void test () {
        Solution solution = new Solution();

//        assertThat(
//                solution.solution(
//                        new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}}
//                )
//        ).isEqualTo(
//            new int[]{2, 1, 1, 0}
//        );

        assertThat(
                solution.solution(
                        new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}
                )
        ).isEqualTo(
                new int[]{4, 0, 1, 2}
        );



    }

    class Solution {
        public int[] solution(int[][] edges) {
            int[] answer = {};
            HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for (int[] edge: edges) {
                int key = edge[0];
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());

                list.add(edge[1]);

                map.put(key, list);
            }



            ArrayList<Integer> visited = new ArrayList<>();
            LinkedList<Integer> q = new LinkedList<>();

            int eightGraphCount = 0;
            int donutGraphCount = 0;
            int rodGraphCount = 0;
            int pointNode = -1;
            int nodeMaxCount = -1;
            for (Integer key :map.keySet()) {
                List<Integer> nodeList = map.get(key);

                if (nodeMaxCount < nodeList.size()) {
                    nodeMaxCount = nodeList.size();
                    pointNode = key;
                }
                boolean isRodGraph = true;
                if (nodeList.size() > 2) {
                    eightGraphCount++;
                    isRodGraph = false;
                }

                for (Integer node : nodeList) {
                    if (!visited.contains(node)) {
                        q.push(node);
                    }

                    if (nodeList.size() == 1 && visited.contains(node)) {
                        donutGraphCount++;
                        isRodGraph = false;
                    }
                }

                while (!q.isEmpty()) {
                    Integer popNode = q.pop();
                    visited.add(popNode);
                }

                if (isRodGraph) {
                    rodGraphCount++;
                }
            }

            return new int[]{pointNode, donutGraphCount, rodGraphCount, eightGraphCount};
        }
    }
}

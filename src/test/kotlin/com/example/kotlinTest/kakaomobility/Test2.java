package com.example.kotlinTest.kakaomobility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Test2 {
    @Test
    void test () {
        Solution solution = new Solution();

//        Assertions.assertThat(solution.solution(
//                4,
//                new int[]{1, 2, 4, 4, 3},
//                new int[]{2, 3, 1, 3, 1}
//                )).isEqualTo(true);
//
//        Assertions.assertThat(solution.solution(
//                4,
//                new int[]{1, 2, 1, 3},
//                new int[]{2, 2, 3, 4}
//        )).isEqualTo(false);
//
//        Assertions.assertThat(solution.solution(
//                4,
//                new int[]{2,4,5,3},
//                new int[]{3,5,6,4}
//        )).isEqualTo(false);


        Assertions.assertThat(solution.solution(
                3,
                new int[]{1,3},
                new int[]{2,2}
        )).isEqualTo(true);


    }

    class Solution {
        public boolean solution(int N, int[] A, int[] B) {
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

            for (int i = 0; i < A.length ; i++) {
                int startNode = A[i];
                int endNode = B[i];

                HashSet<Integer> startSet = map.getOrDefault(startNode, new HashSet<>());
                HashSet<Integer> endSet = map.getOrDefault(endNode, new HashSet<>());

                startSet.add(endNode);
                endSet.add(startNode);

                map.put(startNode, startSet);
                map.put(endNode, endSet);
            }

            if (map.keySet().size() != N) {
                return false;
            }

            for (Integer key :map.keySet()) {
                if (key == N) {
                    continue;
                }

                if (!map.get(key).contains(key + 1)) {
                    return false;
                }
            }

            return true;
        }
    }
}

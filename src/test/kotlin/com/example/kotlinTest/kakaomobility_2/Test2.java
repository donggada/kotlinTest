package com.example.kotlinTest.kakaomobility_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test2 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(
                new int[]{0,0,1,1},
                new int[]{2}
        )).isEqualTo(3);

    }

    @Test
    void test1 () {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(
                new int[]{0,0,0,0,2,3,3},
                new int[]{2,5,6}
        )).isEqualTo(5);

    }

    @Test
    void test2 () {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(
                new int[]{0,0,1,2},
                new int[]{1,2}
        )).isEqualTo(3);

    }


    @Test
    void test3 () {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(
                new int[]{0,3,0,0,5,0,5},
                new int[]{4,2,6,1,0}
        )).isEqualTo(7);

    }

    class Solution {
        public int solution(int[] T, int[] A) {
            Map<Integer, List<Integer>> tree = new HashMap<>();
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int target: A) {
                queue.add(target);
                visited.add(target);
            }

            while (!queue.isEmpty()) {
                Integer skill = queue.poll();
                int childSkill = T[skill];
                if (!visited.contains(childSkill)) {
                    visited.add(childSkill);
                    queue.add(childSkill);
                    count++;
                }
            }


            return A.length + count;
        }
    }


}

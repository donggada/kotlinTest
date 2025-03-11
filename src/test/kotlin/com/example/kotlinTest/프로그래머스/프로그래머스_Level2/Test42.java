package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

public class Test42 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{7,9,1,1,4}
                )
        ).isEqualTo(
                18
        );
    }


    class Solution {
        HashSet<Integer> set;

        public int solution(int[] elements) {
            set = new HashSet<>();

            for (int i = 0; i < elements.length; i++) {
                dfs(i + 1, elements);
            }

            return set.size();
        }

        private void dfs(int targetDepth, int[] elements) {
            for (int i = 0; i < elements.length; i++) {
                int element = elements[i];
                for (int j = i + 1; j < i + targetDepth; j++) {
                    element += elements[j % elements.length];
                }
                set.add(element);
            }
        }

    }

}

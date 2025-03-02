package com.example.kotlinTest.가비아;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test20250205_1 {

    @Test
    void case1() {
        Assertions.assertThat(
                new Solution().solution(
                        new int[]{2,3,4,2,1,2,3,4}
                )
        ).isEqualTo(
                1
        );

    }


    @Test
    void case2() {
        Assertions.assertThat(
                new Solution().solution(
                        new int[]{100, 99}
                )
        ).isEqualTo(
                0
        );

    }

    class Solution {
        static  int answer;
        public int solution(int[] A) {
            answer = Integer.MAX_VALUE;
            int len = A.length;


            for (int i = 0; i < len; i++) {
                boolean[] visited = new boolean[len];
                backTracking(0, len - i, A, visited, new ArrayList<>());
            }

            return answer;
        }

        private void backTracking(int index, int len, int[] A, boolean[] visited, List<Integer> result) {
            if (result.size() == len) {
                if (check(result)) {
                    answer = Math.min(answer, Math.abs(len - A.length));
                    return;
                }
            }

            for (int i = index; i < A.length; i++ ){
                if (!visited[i]) {
                    visited[i] = true;
                    List<Integer> newList = new ArrayList<>(result);
                    newList.add(A[i]);
                    backTracking(i+1, len, A, visited, newList);
                    visited[i] = false;
                }
            }
        }

        private boolean check (List<Integer> result) {
            for (int i = 1; i < result.size(); i++) {
                if(Math.abs(result.get(i) - result.get(i-1)) != 1){
                    return false;
                }
            }
            return true;
        }

    }


}

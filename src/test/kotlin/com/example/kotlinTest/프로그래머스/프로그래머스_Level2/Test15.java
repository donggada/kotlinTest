
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test15 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(3,5)
        ).isEqualTo(
                new int[]{3,1,2}
        );
    }



    class Solution {
        static int count;
        static int[] answer;
        public int[] solution(int n, long k) {
            ArrayList<Integer> list = new ArrayList<>();
            long total = 1;
            for (int i = 1; i < n + 1; i++) {
                list.add(i);
                total *= i;
            }

            k--;
            answer = new int[n];
            int index = 0;
            while (index < n) {
                total /= n - index;
                answer[index] = list.remove((int) (k / total));
                index++;
                k %= total;
            }

//            count = 0;
//            boolean[] visited = new boolean[n];
//            backTracking(n, k, visited, list, new ArrayList<>());
            return answer;
        }

        private void backTracking(int n, long k, boolean[] visited, List<Integer> list, List<Integer> result) {
            if (result.size() == n) {
                count++;
                if (count == k) {
                    answer = new int[n];

                    for (int i = 0; i < n ; i++) {
                        answer[i] = result.get(i);
                    }
                    return;
                }
            }

            for (int i = 0; i < n ; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ArrayList<Integer> newList = new ArrayList<>(result);
                    newList.add(list.get(i));
                    backTracking(n, k, visited, list, newList);
                    visited[i] = false;
                }
            }
        }

    }

}
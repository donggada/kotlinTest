package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {
    
    Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(2, 9)
        ).isEqualTo(
                new int[] {4,5}
        );
        
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(2, 1)
        ).isEqualTo(
                new int[] {-1}
        );

    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(2, 8)
        ).isEqualTo(
                new int[] {4,4}
        );

    }

    class Solution {
        static int[] answer;
        static boolean[] visited;
        static int[] arr;
        static int max = Integer.MIN_VALUE;
        public int[] solution(int n, int s) {
            answer = new int[]{-1};
            visited = new boolean[s];
            arr = new int[s];
            for (int i = 0; i <s ; i++) {
                arr[i] = i+1;
            }

            dfs(0, n, 0, s, new ArrayList<>());
            return answer;
        }

        private void dfs(int depth, int n, int sum, int s, List<Integer> list) {
            if(depth == n) {
                if (sum == s) {
                    Integer reduce = list.stream().reduce(1, (a, b) -> a * b);
                    if (max > reduce) {
                        answer = new int[n];
                        Collections.sort(list);
                        for (int i = 0; i < n ; i++) {
                            answer[i] = list.get(i);
                        }
                    }
                }
                return;
            }

            ArrayList<Integer> newList  = new ArrayList<>(list);
            for (int i = 0; i < s; i++) {
                newList.add(arr[i]);
                dfs(depth+1, n, sum + arr[i], s, newList);
            }

        }
    }
    
}

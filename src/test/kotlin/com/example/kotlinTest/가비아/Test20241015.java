package com.example.kotlinTest.가비아;

import org.junit.jupiter.api.Test;

public class Test20241015 {

    @Test
    void case1() {
        new Solution().solution(5, new int[][] {
                {84, 70}, {60, 55}, {56, 86}, {73,90}, {94,58}
        });
    }

    class Solution {
        static int max;
        static boolean[] visited;
        public int solution(int N ,int[][] A) {
            visited = new boolean[N];
            max = 0;

            dfs(0, Integer.MAX_VALUE, Integer.MAX_VALUE, A);

            System.out.println(max);
            return max;
        }

        private void dfs(int depth, int mathMin, int enMin, int[][] A) {
            if (depth == 3) {
                max = Math.max(max, mathMin + enMin);
                return;
            }

            for (int i = 0; i < A.length ; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth+1, Math.min(mathMin, A[i][0]), Math.min(enMin, A[i][1]), A);
                    visited[i] = false;
                }
            }
        }
    }
}

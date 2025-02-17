package com.example.kotlinTest.kakao_2022_blind_recruitment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1_양궁대회 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0})
        ).isEqualTo(
                new int[]{0,2,2,0,1,0,0,0,0,0,0}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0})
        ).isEqualTo(
                new int[]{-1}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1})
        ).isEqualTo(
                new int[]{1,1,2,0,1,2,2,0,0,0,0}
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3})
        ).isEqualTo(
                new int[]{1,1,1,1,1,1,1,1,0,0,2}
        );
    }

    class Solution {
        static int maxAbs;
        static int[] answer;
        static int[] ryan;
        public int[] solution(int n, int[] info) {
            answer = new int[]{-1};
            maxAbs = 0;
            ryan = new int[11];
            dfs(0,n, info);
            return answer;
        }

        private void dfs(int depth, int n, int[] apeach) {
            if (depth == n) {
                int abs = abs(apeach);
                if (maxAbs <= abs) {
                    maxAbs = abs;
                    answer = ryan.clone();
                }
                return;
            }

            for (int i = 0; i < apeach.length && ryan[i] <= apeach[i] ; i++) {
                ryan[i]++;
                dfs(depth+1, n, apeach);
                ryan[i]--;
            }
        }


        private int abs(int[] info) {
            int apeachCount=0;
            int ryanCount=0;
            for(int i=0; i<11; i++) {
                if (info[i] == 0 && ryan[i] == 0) {
                    continue;
                }

                if (info[i] >= ryan[i]) {
                    apeachCount += (10 - i);
                    continue;
                }

                ryanCount += (10 - i);
            }

            int abs = ryanCount - apeachCount;

            if (abs <= 0) {
                return -1;
            }

            return abs;
        }
    }

}

package com.example.kotlinTest.프로그래머스_Level2;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class Test37 {

    Solution solution = new Solution();

    @Test
    void case1() {
        assertThat(solution.solution(
                        new int[][]{{1, 2}, {2, 3}, {2, 1}} ,4,4
                )
        ).isEqualTo(
                2
        );
    }

    @Test
    void case2() {
        assertThat(solution.solution(
                        new int[][]{{1, 2}, {2, 3}, {2, 1}} ,1,7
                )
        ).isEqualTo(
                0
        );
    }

    @Test
    void case3() {
        assertThat(solution.solution(
                        new int[][]{{3, 3}, {3, 3}} ,7,1
                )
        ).isEqualTo(
                6
        );
    }

    @Test
    void case4() {
        assertThat(solution.solution(
                        new int[][]{{3, 3}, {3, 3}}, 6, 1
                )
        ).isEqualTo(
                -1
        );
    }


    class Solution {
        public int solution(int[][] info, int n, int m) {
            return dp(info,n,m);
        }

        public int dp(int[][] info, int n, int m) {
            int itemCount = info.length;
            int INF = Integer.MAX_VALUE;
            int[][] dp = new int[itemCount + 1][m];

            for (int[] row : dp) {
                Arrays.fill(row, INF);
            }

            dp[0][0] = 0;

            for (int i = 0; i < itemCount; i++) {
                int aTrace = info[i][0];
                int bTrace = info[i][1];

                for (int j = m - 1; j >= 0; j--) {
                    if (dp[i][j] == INF){
                        continue;
                    }

                    int newATrace = dp[i][j] + aTrace;
                    if (newATrace < n) {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], newATrace);
                    }

                    int newBTrace = j + bTrace;
                    if (newBTrace < m) {
                        dp[i + 1][newBTrace] = Math.min(dp[i + 1][newBTrace], dp[i][j]);
                    }
                }
            }

            int result = INF;
            for (int j = 0; j < m; j++) {
                result = Math.min(result, dp[itemCount][j]);
            }

            return (result == INF) ? -1 : result;
        }





        private void dfs(int depth, int index, int[][] info,int n ,int m, int aCount, int bCount) {
            if (aCount >= n || bCount >= m) {
                return;
            }

            if (depth == info.length) {
//                minACount = Math.min(minACount, aCount);
                return;
            }

            for (int i = index; i <info.length ; i++) {
                dfs(depth+1, i+1, info, n ,m , aCount+ info[i][0], bCount);
                dfs(depth+1, i+1, info, n ,m , aCount, bCount+ info[i][1]);
            }

        }
    }
}

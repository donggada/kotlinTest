package com.example.kotlinTest.프로그래머스_Level2;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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


    @Test
    void case5() {
        assertThat(solution.solution(
                        new int[][]{{2, 1}, {3, 2}, {2, 3}}, 4, 5
                )
        ).isEqualTo(
                3
        );
    }
    class Solution {
        static int minACount = Integer.MAX_VALUE;
        public int solution(int[][] info, int n, int m) {
//            dfs(0, 0, info, n,m, 0 ,0);

            return dp(info,n,m);
        }
        private int dp(int[][] info, int n, int m) {
            // DP 테이블 초기화: -1로 채워서 방문하지 않은 상태로 표시
            final int INF = Integer.MAX_VALUE;
            int[][] dp = new int[n + 1][m + 1];

            // DP 초기값 설정
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    dp[i][j] = INF;
                }
            }
            dp[0][0] = 0; // 처음에는 A도둑과 B도둑 모두 흔적이 없으므로 0으로 초기화

            // 물건 하나씩 처리
            for (int[] item : info) {
                int a = item[0]; // A도둑이 남기는 흔적
                int b = item[1]; // B도둑이 남기는 흔적
                // 뒤에서부터 순차적으로 갱신하여 이전 상태를 덮어쓰지 않도록 한다.
                for (int i = n; i >= 0; i--) {
                    for (int j = m; j >= 0; j--) {
                        // A도둑이 물건을 훔친 경우
                        if (i + a <= n) {
                            dp[i + a][j] = Math.min(dp[i + a][j], dp[i][j]);
                        }
                        // B도둑이 물건을 훔친 경우
                        if (j + b <= m) {
                            dp[i][j + b] = Math.min(dp[i][j + b], dp[i][j] + a);
                        }
                    }
                }
            }

            // 결과: A도둑이 남긴 흔적의 최소값 찾기
            int result = INF;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (dp[i][j] != INF) {
                        result = Math.min(result, dp[i][j]);
                    }
                }
            }

            return result == INF ? -1 : result;
        }






        private void dfs(int depth, int index, int[][] info,int n ,int m, int aCount, int bCount) {
            if (aCount >= n || bCount >= m) {
                return;
            }

            if (depth == info.length) {
                minACount = Math.min(minACount, aCount);
                return;
            }

            for (int i = index; i <info.length ; i++) {
                dfs(depth+1, i+1, info, n ,m , aCount+ info[i][0], bCount);
                dfs(depth+1, i+1, info, n ,m , aCount, bCount+ info[i][1]);
            }

        }
    }
}

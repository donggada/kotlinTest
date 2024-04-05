package com.example.kotlinTest.프로그래머스_DP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test3 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(4,3, new int[][]{{2, 2}})
        ).isEqualTo(4);


    }

    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] map = new int[n][m];
            boolean[][] puddleMap = new boolean[n][m];

            for (int[] puddle : puddles) {
                puddleMap[puddle[1] - 1][puddle[0] - 1] = true;
            }

            map[0][0] = 1;

            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m ; j++) {
                    if (puddleMap[i][j]) {
                        // 우물 길
                        continue;
                    }

                    if(i != 0) {
                        map[i][j] += map[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기
                    }

                    if(j != 0) {
                        map[i][j] += map[i][j - 1] % 1000000007; // 왼쪽
                    }

                }
            }

            return map[n-1][m-1] % 1000000007;
        }
    }
}

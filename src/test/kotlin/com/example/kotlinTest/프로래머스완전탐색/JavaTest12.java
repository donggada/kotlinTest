package com.example.kotlinTest.프로래머스완전탐색;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest12 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(80, new int[][]{{80,20},{50,40},{30,10}})
        ).isEqualTo(
            3
        );


    }

    class Solution {
        static boolean[] visit;
        static int count;
        public int solution(int k, int[][] dungeons) {
            count = 0;
            visit = new boolean[dungeons.length];
            self(0, k, dungeons);
            return count + 1;
        }

        private static void self(int depth, int k, int[][] dungeons) {
            for (int i = 0; i <dungeons.length ; i++) {
                if (visit[i] || k < dungeons[i][0]) {
                    continue;
                }
                visit[i] = true;
                self(depth + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
                count = Math.max(count, depth);
            }
        }
    }

}

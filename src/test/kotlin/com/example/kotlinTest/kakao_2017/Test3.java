package com.example.kotlinTest.kakao_2017;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                        4,
                        new int[][] {{0, 0}, {1, 1}, {0, 2}, {2, 0}}
                )
        ).isEqualTo(
                3
        );


    }

    class Solution {
        public int solution(int n, int[][] data) {
            int answer = 0;

            for (int i = 0; i < n ; i++) {
                int[] start = data[i];
                for (int j = i+1; j < n ; j++) {
                    int[] end = data[j];

                    int nx = Math.abs(start[0] - end[0]);
                    int ny = Math.abs(start[1] - end[1]);

                    if (ny != 0 && nx == ny) {
                        System.out.print("i = " + i);
                        System.out.println("j = " + j);
                        answer++;
                    }

                }
            }
            return answer;
        }

        public int self(int depth,int index, int[][] data) {
            if (depth == 2) {
                return 1;
            }

            for (int i = index+1; i <data.length ; i++) {
                self(depth+1, i, data);
            }



            return 0;
        }
    }
}


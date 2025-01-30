
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test20 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(4)
        ).isEqualTo(
                new int[]{1,2,9,3,10,8,4,5,6,7}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(5)
        ).isEqualTo(
                new int[]{1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(6)
        ).isEqualTo(
                new int[]{1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}
        );
    }



    class Solution {
        static int[][] arr;
        static int num = 1;
        public int[] solution(int n) {
            int[] answer = {};
            arr = new int[n][n];

            for (int i = 0; i < n ; i++) {
                if (i % 3 == 0) {
                    rowPoll(i, n  - i/3, i/3);
                    continue;
                }

                if (i % 3 == 1) {
                    colPoll(i, n, i/3);
                    continue;
                }

                reverserRowPoll(n, i, i/3);
            }


            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 0) {
                        list.add(arr[i][j]);
                    }
                }
            }

            answer = new int[list.size()];

            for (int i = 0; i <list.size() ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }

        private void rowPoll(int start, int end, int depth) {
            for (int i = start - depth; i < end ; i++) {
                arr[i][depth] = num;
                num++;
            }

        }

        private void colPoll(int start, int end, int depth) {
            for (int i = start - depth; i < end - depth ; i++) {
                arr[end - depth - 1][i-depth] = num;
                num++;
            }
        }

        private void reverserRowPoll(int start, int end, int depth) {
             for (int i = start - end  + depth; i > depth; i--) {
                arr[i+depth][i] = num;
                num++;
            }
        }
    }








}
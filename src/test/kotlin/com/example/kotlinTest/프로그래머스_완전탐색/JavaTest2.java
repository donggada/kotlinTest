package com.example.kotlinTest.프로그래머스_완전탐색;


import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest2 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{1,2,3,4,5})
        ).isEqualTo(
            new int[]{1}
        );

        Assertions.assertThat(
            solution.solution(new int[]{1,3,2,4,2})
        ).isEqualTo(
            new int[]{1,2,3}
        );
    }

    class Solution {
        static int[] pr1 = {1, 2, 3, 4, 5};
        static int[] pr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        static int[] pr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        public int[] solution(int[] answers) {
            int [] arr = new int[3];
            for (int i = 0; i < answers.length ; i++) {
                if (answers[i] == pr1[i % pr1.length]) {
                    arr[0] = arr[0] + 1;
                }

                if (answers[i] == pr2[i % pr2.length]) {
                    arr[1] = arr[1] + 1;
                }

                if (answers[i] == pr3[i % pr3.length]) {
                    arr[2] = arr[2] + 1;
                }

            }

            Integer max = Arrays.stream(arr).max().getAsInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == max) {
                    list.add(i);
                }
            }

            int[] ints = new int[list.size()];
            for (int i = 0; i <list.size() ; i++) {
                ints[i] = list.get(i) + 1;
            }
            return ints;
        }
    }

}

package com.example.kotlinTest.프로그래머스_정렬;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest1 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})
        ).isEqualTo(
            new int[]{5, 6, 3}
        );


    }

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int x = 0; x < commands.length ; x++) {
                int[] command = commands[x];
                int start = command[0] -1;
                int end = command[1] -1;
                int index = command[2] -1;

                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= end ; i++) {
                    list.add(array[i]);
                }
                Collections.sort(list);
                answer[x] = list.get(index);
            }

            return answer;
        }
    }

}

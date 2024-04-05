package com.example.kotlinTest.프로그래머스_DP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test2 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}})
        ).isEqualTo(30);


    }

    class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int size = triangle.length;
            int[][] arr = new int[size][size];
            arr[0][0] = triangle[0][0];
            for (int i = 1; i <size ; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (j == 0) {
                        arr[i][j] = arr[i-1][0] + triangle[i][j];
                        continue;
                    }

                    if (j == triangle[i].length -1) {
                        arr[i][j] = arr[i-1][j-1] + triangle[i][j];
                        continue;
                    }
                    int num = triangle[i][j];
                    arr[i][j] = Math.max(arr[i-1][j-1] + num, arr[i-1][j] + num);
                }
            }


            return Arrays.stream(arr[size - 1]).max().getAsInt();
        }
    }
}

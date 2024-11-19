package com.example.kotlinTest.아정당;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test2 {


    @Test
    void case1() {
        Assertions.assertThat(
                new Solution().solution(
                        new int[][]{{85, 90}, {65, 67}, {88, 87}, {88, 87}, {73, 81}, {65, 89}, {99, 100}, {80,94}})
        ).isEqualTo(new int[]{4, 8, 2, 3, 6, 7, 1, 5});
    }

    @Test
    void case2() {
        Assertions.assertThat(
                new Solution().solution(
                        new int[][]{{85, 90}, {91, 87}, {88, 87}})
        ).isEqualTo(new int[]{2, 1, 3});
    }

    class Solution {
        public int[] solution(int[][] scores) {
            int length = scores.length;
            int[] answer = new int[length];
            int[][] arr = new int[length][3];

            int pSum1 = 0;
            int pSum2 = 0;

            for (int i = 0; i <length ; i++) {
                arr[i][0] = scores[i][0];
                arr[i][1] = scores[i][1];
                arr[i][2] = i+1;
                pSum1 += scores[i][0];
                pSum2 += scores[i][1];
            }

            int finalPSum1 = pSum1;
            int finalPSum2 = pSum2;

            Arrays.sort(arr,
                    (arr1, arr2) ->
                            arr1[0] + arr1[1] != arr2[0] + arr2[1] ? (arr2[0] + arr2[1]) - (arr1[0] + arr1[1])
                                    : finalPSum1 != finalPSum2 ? finalPSum1 > finalPSum2 ?  arr2[1] - arr1[1] : arr2[0] - arr1[0]
                                    : arr1[2] - arr2[2]);


            for (int i = 0; i < length; i++) {
                answer[arr[i][2]-1] = i+1;
            }

            return answer;
        }
    }
}

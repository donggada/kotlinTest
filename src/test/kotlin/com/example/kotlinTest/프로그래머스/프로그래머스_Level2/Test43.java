package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Test43 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{1,3,2} , new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}
                )
        ).isEqualTo(
                12
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{0,1,1} , new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
                )
        ).isEqualTo(
                50
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new int[]{0,1,0} , new String[]{"diamond", "iron", "iron", "iron", "iron", "diamond", "diamond", "iron", "iron", "iron"}
                )
        ).isEqualTo(
                9
        );
    }


    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int size = Math.min(minerals.length / 5 + (minerals.length % 5 == 0 ? 0 : 1), Arrays.stream(picks).sum());
            int[][] arr = new int[size][3];
            for (int i = 0; i < size ; i++) {
                int diamondCount = 0;
                int ironCount = 0;
                int stoneCount = 0;
                for (int j = i * 5; j < Math.min((i+1) * 5, minerals.length) ; j++) {
                    if (minerals[j].equals("diamond")) {
                        diamondCount++;
                        continue;
                    }

                    if (minerals[j].equals("iron")) {
                        ironCount++;
                        continue;
                    }

                    stoneCount++;
                }

                arr[i][0] = diamondCount;
                arr[i][1] = ironCount;
                arr[i][2] = stoneCount;
            }

            Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] == arr2[1] ? arr2[2] - arr1[2] : arr2[1] - arr1[1] : arr2[0] - arr1[0]);
            int count = 0;
            for (int i = 0; i <picks.length ; i++) {
                for (int j = 0; j < picks[i]; j++) {
                    if (size == count) {
                        return answer;
                    }
                    answer += cal(i, arr[count]);
                    count++;
                }
            }
            return answer;
        }

        private int cal (int pick, int[] minerals) {
            int result = 0;
            for (int i = 0; i <minerals.length ; i++) {
                int d = pick - i;
                if (d < 0) {
                    d = 0;
                }
                result += (int) (minerals[i] * Math.pow(5,d));
            }

            return result;
        }
    }
}

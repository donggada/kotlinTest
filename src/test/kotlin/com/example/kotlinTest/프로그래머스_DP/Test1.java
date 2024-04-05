package com.example.kotlinTest.프로그래머스_DP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class Test1 {

    @Test
    void  test() {
        Solution solution = new Solution();

//        Assertions.assertThat(
//                solution.solution(5, 12)
//        ).isEqualTo(4);
//
//        Assertions.assertThat(
//                solution.solution(2, 11)
//        ).isEqualTo(3);

        Assertions.assertThat(
                solution.solution(5, 31168)
        ).isEqualTo(-1);


    }

    class Solution {
        public int solution(int N, int number) {
            if (N == number) {
                return 1;
            }

            ArrayList<HashSet<Integer>> dp = new ArrayList<>();

            for (int i = 0; i < 9 ; i++) {
                dp.add(new HashSet<>());
            }

            dp.get(1).add(N);

            for (int i = 2; i < 9 ; i++) {
                dp.get(i).add(Integer.valueOf(N + String.valueOf(N).repeat(i - 1)));

                for (int j = 1; j < i ; j++) {
                    int k = i - j;
                    for (int num1: dp.get(j)) {
                        for (int num2 : dp.get(k)) {
                            dp.get(i).add(num1 + num2);
                            dp.get(i).add(num1 - num2);
                            dp.get(i).add(num1 * num2);
                            if (num2 != 0) {
                                dp.get(i).add(num1 / num2);
                            }
                        }
                    }
                }

                if (dp.get(i).contains(number)) {
                    return i;
                }
            }

            return -1;
        }
    }
}

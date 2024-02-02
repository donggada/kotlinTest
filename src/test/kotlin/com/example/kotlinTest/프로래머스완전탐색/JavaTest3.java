package com.example.kotlinTest.프로래머스완전탐색;


import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest3 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution("17")
        ).isEqualTo(
            3
        );

        Assertions.assertThat(
            solution.solution("011")
        ).isEqualTo(
            2
        );


    }

    class Solution {
        static ArrayList<Integer> list;
        public int solution(String numbers) {
            int answer = 0;
            list = new ArrayList();

            return answer;
        }

        private static void self (String numbers) {
            for (int i = 0; i <numbers.length() ; i++) {

            }
        }
    }

}

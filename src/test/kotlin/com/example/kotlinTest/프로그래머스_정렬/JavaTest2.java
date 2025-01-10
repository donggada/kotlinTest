package com.example.kotlinTest.프로그래머스_정렬;


import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest2 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{6, 10, 2})
        ).isEqualTo(
            "6210"
        );

        Assertions.assertThat(
            solution.solution(new int[]{3, 30, 34, 5, 9})
        ).isEqualTo(
            "9534330"
        );


    }

    class Solution {
        public String solution(int[] numbers) {

            StringBuilder result = new StringBuilder();
            String[] strings = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                strings[i] = numbers[i] + "";
            }

            Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            if (strings[0].equals("0")) {
                return "0";
            }

            for (String str : strings) {
                result.append(str);
            }

            return result.toString();
        }
    }

}

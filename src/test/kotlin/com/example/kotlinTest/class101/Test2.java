package com.example.kotlinTest.class101;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Test2 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new String[]{"()", "(()", ")()", "()"}, new String[]{")()", "()", "(()"})
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[]{"()", "(()", "(", "(())"}, new String[]{")()", "()", "(())", ")()"})
        ).isEqualTo(
                8
        );
    }

    class Solution {
        public long solution(String[] arr1, String[] arr2) {
            long answer = 0;

            HashSet<String> totalSet = new HashSet<>();

            for (String s1 : arr1) {
                for (String s2: arr2) {
                    String sumString = s1 +  s2;

                    if (totalSet.contains(sumString)) {
                        answer++;
                        continue;
                    }

                    if (isValid(sumString)) {
                        answer++;
                        totalSet.add(sumString);
                    }

                }
            }
            return answer;
        }



        private boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.add(c);
                    continue;
                }

                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }

            return stack.isEmpty();
        }
    }
}

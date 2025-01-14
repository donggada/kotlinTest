package com.example.kotlinTest.class101;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Test3 {

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

            int arr1Count = 0;
            int arr2Count = 0;
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();
            for (String s : arr1) {
                if (isValid(s)) {
                    arr1Count++;
                    continue;
                }
                list1.add(s);
            }

            for (String s : arr2) {
                if (isValid(s)) {
                    arr2Count++;
                    continue;
                }
                list2.add(s);
            }



            for (String s1 : list1) {
                for (String s2: list2) {
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
            return answer + ((long) arr1Count * arr2Count);
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


package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Stack;

public class Test10 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("[](){}")
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution("}]()[{")
        ).isEqualTo(
                2
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution("[)(]")
        ).isEqualTo(
                0
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution("}}}")
        ).isEqualTo(
                0
        );
    }


    class Solution {
        public int solution(String s) {
            int answer = 0;
            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(i) + s.substring(0, i);
                Stack<Character> stack = new Stack<>();

                for (char c : str.toCharArray()) {
                    if (stack.isEmpty()) {
                        stack.add(c);
                        continue;
                    }

                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }

                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }

                    if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }

                    stack.add(c);
                }

                if (stack.isEmpty()) {
                    answer++;
                }
            }


            return answer;
        }
    }

}
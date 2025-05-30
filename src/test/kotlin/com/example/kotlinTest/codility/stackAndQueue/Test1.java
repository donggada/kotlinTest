package com.example.kotlinTest.codility.stackAndQueue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Stack;

public class Test1 {
    private final Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(solution.solution("{[()()]}")).isEqualTo(1);
    }

    @Test
    void case2() {
        Assertions.assertThat(solution.solution("([)()]")).isEqualTo(0);
    }

    @Test
    void case3() {
        Assertions.assertThat(solution.solution("{{{{")).isEqualTo(0);
    }

    class Solution {
        private static final String CLOSING_BRACKETS = ")]}";

        public int solution(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (isClosingBracket(c)) {
                    if (stack.isEmpty() || !isMatchingBracket(stack.pop(), c)) {
                        return 0;
                    }
                    continue;
                }

                stack.push(c);
            }
            
            return stack.isEmpty() ? 1 : 0;
        }
        
        private boolean isClosingBracket(char c) {
            return CLOSING_BRACKETS.indexOf(c) != -1;
        }
        
        private boolean isMatchingBracket(char opening, char closing) {
            return switch (closing) {
                case ')' -> opening == '(';
                case ']' -> opening == '[';
                case '}' -> opening == '{';
                default -> false;
            };
        }
    }
}

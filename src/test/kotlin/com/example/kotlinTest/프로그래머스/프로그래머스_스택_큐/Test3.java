package com.example.kotlinTest.프로그래머스.프로그래머스_스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution("()()")
        ).isEqualTo(
            true
        );


        Assertions.assertThat(
            solution.solution("(())()")
        ).isEqualTo(
            true
        );

        Assertions.assertThat(
            solution.solution(")()(")
        ).isEqualTo(
            false
        );

        Assertions.assertThat(
            solution.solution("(()(")
        ).isEqualTo(
            false
        );


    }


    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);
                if (stack.isEmpty() && c == ')') {
                    return false;
                }

                if (c == '(') {
                    stack.add(')');
                }

                if (c == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

            }

            if (!stack.isEmpty()) {
                return false;
            }

            return true;
        }
    }

}

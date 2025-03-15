package com.example.kotlinTest.kakao_2020_blind_recruitment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Test1_괄호변환 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("(()())()")
        ).isEqualTo(
                "(()())()"
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(")(")
        ).isEqualTo(
                "()"
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution("()))((()")
        ).isEqualTo(
                "()(())()"
        );
    }

    class Solution {
        public String solution(String p) {
            return process(p);
        }

        public String process(String p) {
            if (p.isEmpty()) {
                return p;
            }

            int a = 0;
            int b = 0;
            int index = 0;
            for (int i =0; i < p.length(); i++) {
                char c = p.charAt(i);

                if (c == '(') {
                    a++;
                }

                if (c == ')') {
                    b++;
                }


                if (b == a) {
                    index = i;
                    break;
                }
            }

            String u = p.substring(0, index+1);
            String v = p.substring(index+1);

            if (check(u)) {
                return u + process(v);
            }


            return "(" + process(v) + ")" + toReverse(u) ;
        }

        private boolean check(String u) {
            Stack<Character> stack = new Stack<>();
            for (char c : u.toCharArray()) {
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

        private String toReverse(String u) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                if (c == '(') {
                    sb.append(")");
                    continue;
                }
                sb.append("(");
            }

            return sb.toString();
        }
    }
}

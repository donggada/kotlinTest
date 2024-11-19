package com.example.kotlinTest.온다;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Test2 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution("abcz")
        ).isEqualTo(1);
    }

    @Test
    void case2() {
        assertThat(
                new Solution().solution("zabzczxa")
        ).isEqualTo(3);
    }

    @Test
    void case3() {
        assertThat(
                new Solution().solution("abcd")
        ).isEqualTo(0);
    }


    class Solution {
        public int solution(String s) {
            int answer = 0;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);

                if ((c == 'a' || c == 'z') && stack.isEmpty()) {
                    stack.add(c);
                    continue;
                }

                if ((c == 'a' || c == 'z') && !stack.isEmpty()) {
                    if(stack.peek() != c) {
                        answer++;
                    }
                    stack.pop();
                    stack.add(c);
                }

            }

            return answer;
        }
    }
}

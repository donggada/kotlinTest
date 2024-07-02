package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class Test1 {

    @Test
    void case1() {
        assertThat(new Solution().solution("baabaa")).isEqualTo(1);
    }

    @Test
    void case2() {
        assertThat(new Solution().solution("cdcd")).isEqualTo(0);
    }

    class Solution
    {
        public int solution(String s)
        {
            int answer = -1;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);

                if (stack.isEmpty()) {
                    stack.add(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                    continue;
                }

                stack.add(c);
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}

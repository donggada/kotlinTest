package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Test3 {

    @Test
    void case1() {
        assertThat(new Solution().solution("[](){}")).isEqualTo(3);
    }

    @Test
    void case2() {
        assertThat(new Solution().solution("}]()[{")).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(new Solution().solution("[)(]")).isEqualTo(0);
    }

    @Test
    void case4() {
        assertThat(new Solution().solution("}}}")).isEqualTo(0);
    }

    class Solution {
        public int solution(String s) {
            int answer = 0;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);

                if (c == '{' || c == '(' || c == '[') {
                    stack.add(c);
                    continue;
                }

                Character peek = stack.peek();

                if (peek == '}' && c == '}') {
                    answer++;
                }
            }
            return answer;
        }
    }
}

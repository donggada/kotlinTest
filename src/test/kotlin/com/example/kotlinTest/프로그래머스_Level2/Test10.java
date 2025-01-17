
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

            for (int i = 0; i < s.length() ; i++) {
                set.add(s.substring(i) + s.substring(0, i));
            }

            for (String string : set) {
                answer = Math.max(answer,cal(string));
            }

            return answer;
        }
    }

    private int cal (String s) {
        int count = 0;
        Stack<Character> tStack = new Stack<>();
        Stack<Character> mStack = new Stack<>();
        Stack<Character> sStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '}') {
                if(!tStack.isEmpty()) {
                    tStack.pop();
                    count++;
                }
            }

            if (c == '{') {
                tStack.add(c);
            }

            if (c == ']') {
                if(!mStack.isEmpty()) {
                    mStack.pop();
                    count++;
                }
            }

            if (c == '[') {
                mStack.add(c);
            }

            if (c == ')') {
                if(!sStack.isEmpty()) {
                    sStack.pop();
                    count++;
                }
            }

            if (c == '(') {
                sStack.add(c);
            }
        }
        return count;
    }
}

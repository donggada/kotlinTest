package com.example.kotlinTest.프로그래머스.프로그래머스_문자열;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Test1 {
    // JadenCase 문자열 만들기

    @Test
    void case1() {
        Solution solution = new Solution();
        assertThat(
                solution.solution("3people unFollowed me")
        ).isEqualTo("3people Unfollowed Me");
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        assertThat(
                solution.solution("for the last week")
        ).isEqualTo("For The Last Week");
    }

    class Solution {
        public String solution(String s) {
            s = s.toLowerCase();
            boolean check = true;
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    check = true;
                } else if (check) {
                    // 대문자로 변경
                    c = Character.toUpperCase(c);
                    check = false;
                }
                sb.append(c);
            }

            return sb.toString();
        }
    }
}

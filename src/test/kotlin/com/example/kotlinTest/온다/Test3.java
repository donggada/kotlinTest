package com.example.kotlinTest.온다;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

public class Test3 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution("abcabcdefabc")
        ).isEqualTo("def");
    }

    @Test
    void case2() {
        assertThat(
                new Solution().solution("abxdeydeabz")
        ).isEqualTo("xyz");
    }

    @Test
    void case3() {
        assertThat(
                new Solution().solution("abcabca")
        ).isEqualTo("bcbc");
    }
    @Test
    void case4() {
        assertThat(
                new Solution().solution("ABCabcA")
        ).isEqualTo("BCbc");
    }


    class Solution {

        public String solution(String interview) {
            String lowerInterview = interview.toLowerCase();

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < lowerInterview.length(); i++) {
                for (int j = i + 1; j <= lowerInterview.length(); j++) {
                    String pattern = lowerInterview.substring(i, j);
                    map.put(pattern, map.getOrDefault(pattern, 0) + 1);
                }
            }

            int maxCount = 0;
            for (int count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }


            List<String> mostPatterns = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    mostPatterns.add(entry.getKey());
                }
            }

            String result = interview;
            for (String pattern : mostPatterns) {
                result = result.replaceAll("(?i)" + pattern, ""); // 대소문자 무시하고 패턴 제거
            }

            return result;
        }
    }
}

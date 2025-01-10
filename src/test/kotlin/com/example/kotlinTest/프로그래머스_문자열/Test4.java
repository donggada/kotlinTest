package com.example.kotlinTest.프로그래머스_문자열;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test4 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("try hello world")
        ).isEqualTo(
                "TrY HeLlO WoRlD"
        );
    }


    class Solution {
        public String solution(String s) {
            StringBuffer answer = new StringBuffer();

            String[] wordArray = s.split("");
            int count = 0;

            for (String word : wordArray) {
                if (word.equals(" ")) {
                    answer.append(word);
                    count = 0;
                    continue;
                }

                if (count % 2 == 0) {
                    answer.append(word.toUpperCase());
                    count++;
                    continue;
                }

                answer.append(word.toLowerCase());
                count++;
            }

            return answer.toString();
        }
    }
}

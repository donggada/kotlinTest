package com.example.kotlinTest.kakao_2020_blind_recruitment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Test2 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("aabbaccc")
        ).isEqualTo(
                7
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution("ababcdcdababcdcd")
        ).isEqualTo(
                9
        );
    }

    @Test
    void cas3() {
        Assertions.assertThat(
                solution.solution("abcabcdede")
        ).isEqualTo(
                8
        );
    }

    @Test
    void cas4() {
        Assertions.assertThat(
                solution.solution("abcabcabcabcdededededede")
        ).isEqualTo(14
        );
    }
    @Test
    void cas5() {
        Assertions.assertThat(
                solution.solution("xababcdcdababcdcd")
        ).isEqualTo(17
        );
    }

    class Solution {
        public int solution(String s) {
            int answer = s.length();

            for(int i=1; i <= s.length() / 2; i++){
                int count = 1;
                StringBuilder result = new StringBuilder();
                String word = s.substring(0, i);
                for(int j=i; j <= s.length(); j+=i){
                    String nextWord = s.substring(j, Math.min(j + i, s.length()));

                    if(word.equals(nextWord)){
                        count++;
                        continue;
                    }

                    if (count > 1) {
                        result.append(count);
                    }

                    result.append(word);
                    word = nextWord;
                    count = 1;
                }

                result.append(word);
                answer = Math.min(answer, result.length());
            }

            return answer;
        }
    }
}

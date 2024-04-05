package com.example.kotlinTest.프로그래머스_완전탐색;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaTest7 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution("AAAAE")
        ).isEqualTo(
            6
        );

        Assertions.assertThat(
                solution.solution("AAAE")
        ).isEqualTo(
                10
        );

        Assertions.assertThat(
                solution.solution("I")
        ).isEqualTo(
                1563
        );

        Assertions.assertThat(
                solution.solution("EIO")
        ).isEqualTo(
                1189
        );


    }

    class Solution {
        static List<String> wordList = List.of("A", "E", "I", "O", "U");
        static List<String> currList;
        static int count = 0;
        public int solution(String word) {
            currList = new ArrayList<>();


            backTracing("", 0, word);

            if (currList.contains(word)) {
                return currList.indexOf(word);
            }

            return -1;
        }

        static void backTracing (String word, int index, String target) {
            currList.add(word);

            if (index == 5 || target.equals(word)) {
                return;
            }

            for (int i = 0; i < wordList.size() ; i++) {
                backTracing(word + wordList.get(i), index + 1, target);
            }


        }
    }

}

package com.example.kotlinTest.CJMnet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test4 {

    @Test
    void case1() {
        Assertions.assertThat(new Solution().solution(
                6, "hi bye", 1
        )).isEqualTo("_____h");
    }

    @Test
    void case2() {
        Assertions.assertThat(new Solution().solution(
                6, "hi bye", 2
        )).isEqualTo("____hi");
    }

    @Test
    void case3() {
        Assertions.assertThat(new Solution().solution(
                6, "hi bye", 6
        )).isEqualTo("hi_bye");
    }

    class Solution {
        public String solution(int n, String text, int second) {
            StringBuffer result = new StringBuffer();
            Queue<String> queue = new LinkedList<>();

            for (int i = 0; i < second; i++) {
                queue.add(String.valueOf(text.charAt(i)));
            }

            for (int i = 0; i <n - second ; i++) {
                result.append("_");
            }

            while (!queue.isEmpty()) {
                String poll = queue.poll();

                if (poll.equals(" ")) {
                    poll = "_";
                }

                result.append(poll);
            }

            return result.toString();
        }
    }
}



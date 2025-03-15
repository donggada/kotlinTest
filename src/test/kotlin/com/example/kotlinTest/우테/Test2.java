package com.example.kotlinTest.우테;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Test2 {

    Solution solution = new Solution ();


    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("qwertyuiopasdfghjklzxcvbnm", new String[]{"c", "cplusplus", "csharp", "java", "javascript", "python"})
        ).isEqualTo(
                new String[]{"python", "java", "javascript", "c", "cplusplus", "csharp"}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution("zyxwvutsrqponmlkjihgfedcba", new String[]{"wow", "we", "have", "to", "sort", "in", "inverse", "order"})
        ).isEqualTo(
          new String[]{"wow", "we", "to", "sort", "order", "in", "inverse", "have"}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution("qazwsxedcrfvtgbyhnujmikolp", new String[]{"onlyoneword"})
        ).isEqualTo(
                new String[]{"onlyoneword"}
        );
    }

    class Solution {
        public String[] solution(String order, String[] words) {
            HashMap<Character, Integer> orderMap = new HashMap<>();

            for (int i = 0; i < order.length() ; i++) {
                orderMap.put(order.charAt(i), i);
            }

            Arrays.sort(words, (w1, w2) -> {
                int len = Math.min(w1.length(), w2.length());

                for (int i = 0; i < len; i++) {
                    char charW1 = w1.charAt(i);
                    char charW2 = w2.charAt(i);

                    if (charW1 != charW2) {
                        int rank1 = orderMap.getOrDefault(charW1, Integer.MAX_VALUE);
                        int rank2 = orderMap.getOrDefault(charW2, Integer.MAX_VALUE);
                        return rank1 - rank2;
                    }
                }
                return w1.length() - w2.length();
            });


            return words;
        }
    }

}

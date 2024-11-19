package com.example.kotlinTest.CJMnet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class Test5 {

    @Test
    void case1() {
        Assertions.assertThat(new Solution().solution(
                new String[]{
                        "(required) agreement is required",
                        "(option) agreement is option"
                },
                new String[]{
                        "disagree",
                        "agree"
                }
        )).isEqualTo(new int[]{0});
    }

    @Test
    void case2() {
        Assertions.assertThat(new Solution().solution(
                new String[]{
                        "(required) agreement is required",
                        "(required) agreement is required",
                        "(option) agreement is option",
                        "(required) agreement is required",
                },
                new String[]{"agree","disagree", "disagree", "disagree"}
        )).isEqualTo(new int[]{1,3});
    }

    class Solution {
        public int[] solution(String[] items, String[] agreement) {

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <items.length ; i++) {
                String agreeType = items[i].substring(1).split("[)]")[0];

                if (agreeType.equals("required") && agreement[i].equals("disagree")) {
                    result.add(i);
                }
            }
            int[] answer;
            answer = new int[result.size()];

            for (int i = 0; i < result.size() ; i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }
    }
}



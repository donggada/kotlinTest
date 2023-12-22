package com.example.kotlinTest;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest11 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})
        ).isEqualTo("leo");

        Assertions.assertThat(
            solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"})
        ).isEqualTo("vinko");

        Assertions.assertThat(
            solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})
        ).isEqualTo("mislav");
    }

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Boolean> resultNameMap = new HashMap<>();
            HashMap<String, Integer> resultCountMap = new HashMap<>();

            for (String name : participant) {
                if (resultCountMap.containsKey(name)) {
                    resultCountMap.put(name, resultCountMap.get(name) + 1);
                } else {
                    resultCountMap.put(name, 1);
                }
            }

            for (String completionName : completion) {
                resultNameMap.put(completionName, true);
                resultCountMap.put(completionName, resultCountMap.get(completionName) -1);
            }

            for (String name : participant) {
                if(!resultNameMap.getOrDefault(name, false) || resultCountMap.get(name) != 0) {
                    answer = name;
                }
            }


            return answer;
        }
    }

}

package com.example.kotlinTest.매드업;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test1 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new String[]{"covy -", "teo covy", "felix teo", "vex covy"}, 123)
        ).isEqualTo(
            new String[]{"covy 258", "teo 123", "felix 0", "vex 0"}
        );

    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[]{"a -", "b a", "c b", "d c", "e d", "f d"}, 500)
        ).isEqualTo(
                new String[]{"d 1000", "c 600", "b 560", "a 555", "e 0", "f 0"}
        );

    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new String[]{"ww -", "xx -", "yy -", "zz yy"}, 200)
        ).isEqualTo(
                new String[]{"yy 200", "ww 0", "xx 0", "zz 0"}
        );

    }

    class Solution {
        public String[] solution(String[] members, int p) {
            Map<String, Integer> pointMap = new LinkedHashMap<>(); // 가입 순서 유지
            Map<String, String> recommendMap = new HashMap<>();

            for (String m : members) {
                String[] sp = m.split(" ");
                String newCustomer = sp[0];
                String recommender = sp[1];

                recommendMap.put(newCustomer, recommender);
                pointMap.put(newCustomer, 0);
            }


            for (String m : members) {
                String[] sp = m.split(" ");
                String newCustomer = sp[0];


                String recommender = recommendMap.getOrDefault(newCustomer, "-");
                int point = p;

                while (!recommender.equals("-")) {
                    pointMap.put(recommender, point + pointMap.getOrDefault(recommender, 0));
                    recommender = recommendMap.getOrDefault(recommender, "-");
                    point /= 10;
                }
            }


            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(pointMap.entrySet());
            sortedList.sort((a, b) -> {
                if (!b.getValue().equals(a.getValue())) {
                    return b.getValue().compareTo(a.getValue());
                }
                return 0;
            });


            List<String> result = new ArrayList<>();
            String[] answer = new String[members.length];
            for (int i = 0; i < sortedList.size() ; i++) {
                answer[i] = sortedList.get(i).getKey() + " " + sortedList.get(i).getValue();
            }
            for (Map.Entry<String, Integer> entry : sortedList) {
                result.add(entry.getKey() + " " +  entry.getValue());
            }


            return answer;
        }
    }
}

package com.example.kotlinTest.프로그래머스_해시;

import java.util.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest13 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new String[]{"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"})
        ).isEqualTo(new String[]{"bob"});


        Assertions.assertThat(
            solution.solution(new String[]{"alex pizza pasta steak", "bob noodle sandwich pasta", "choi pizza sandwich pizza", "alex pizza pasta steak"})
        ).isEqualTo(new String[]{"alex", "bob"});

    }

    class Solution {

        public String[] solution(String[] str) {

            HashMap<String, Set<String>> map = new HashMap<>();
            HashMap<Integer, List<String>> resultMap = new HashMap<>();

            for (String s : str) {
                String[] split = s.split(" ");
                String name = split[0];

                if (map.containsKey(name)) {
                    Set<String> set = map.get(name);
                    for (int i = 1; i <split.length ; i++) {
                        set.add(split[i]);
                    }
                } else {
                    HashSet<String> set = new HashSet<>();
                    for (int i = 1; i <split.length ; i++) {
                        set.add(split[i]);
                    }
                    map.put(name,set);
                }
            }

            int maxSize = 0;

            for (String name :map.keySet()) {
                int size = map.get(name).size();
                maxSize = Math.max(size, maxSize);

                if (resultMap.containsKey(size)) {
                    List<String> nameList = resultMap.get(size);
                    nameList.add(name);
                } else {
                    ArrayList<String> nameList = new ArrayList<>();
                    nameList.add(name);
                    resultMap.put(size, nameList);
                }
            }
            String[] answer = resultMap.get(maxSize).toArray(new String[0]);
            Arrays.sort(answer);

            return answer;
        }
    }

}


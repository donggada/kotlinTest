package com.example.kotlinTest.프로그래머스_문자열;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test3 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new String[]{"sun", "bed", "car"}, 1)
        ).isEqualTo(
                new String[]{"car", "bed", "sun"}
        );
    }


    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[]{"abce", "abcd", "cdx"}, 2)
        ).isEqualTo(
                new String[]{"abcd", "abce", "cdx"}
        );

    }

    class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};
            HashMap<Character, List<String>> map = new HashMap<>();
            List<String> result = new ArrayList<>();

            for (String s : strings) {
                char key = s.charAt(n);

                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);
                map.put(key, list);
            }

            List<Character> ketList = new ArrayList<>(map.keySet());
            Collections.sort(ketList);

            for (char k : ketList) {
                List<String> valList = map.get(k);
                Collections.sort(valList);
                result.addAll(valList);
            }

            return result.toArray(new String[0]);
        }
    }
}

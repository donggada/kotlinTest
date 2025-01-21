
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test13 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("FRANCE", "french")
        ).isEqualTo(
                16384
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution("handshake", "shake hands")
        ).isEqualTo(
                65536
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution("aa1+aa2", "AAAA12")
        ).isEqualTo(
                43690
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution("E=M*C^2", "e=m*c^2")
        ).isEqualTo(
                65536
        );
    }

    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            HashMap<String, Integer> map1 = new HashMap<>();
            HashMap<String, Integer> map2 = new HashMap<>();

            str1 = str1.toUpperCase();
            for (int i = 0; i <str1.length()-1 ; i++) {
                char c1 = str1.charAt(i);
                char c2 = str1.charAt(i+1);

                if (check(c1) && check(c2)) {
                    String key = String.valueOf(c1) + c2;
                    Integer count = map1.getOrDefault(key, 0);
                    map1.put(key, count+1);
                }
            }

            str2 = str2.toUpperCase();
            for (int i = 0; i < str2.length()-1 ; i++) {
                char c1 = str2.charAt(i);
                char c2 = str2.charAt(i+1);

                if (check(c1) && check(c2)) {
                    String key = String.valueOf(c1) + c2;
                    Integer count = map2.getOrDefault(key, 0);
                    map2.put(key, count+1);
                }
            }
            HashSet<String> set = new HashSet<>();
            set.addAll(map1.keySet());
            set.addAll(map2.keySet());
            int overlappingCount = 0;
            int unionCount = 0;
            for (String key : set) {
                if (map1.containsKey(key) && map2.containsKey(key)) {
                    overlappingCount += Math.min(map1.get(key), map2.get(key));
                    unionCount += Math.max(map1.get(key), map2.get(key));
                    continue;
                }

                if (map1.containsKey(key)) {
                    unionCount += map1.get(key);
                    continue;
                }

                if (map2.containsKey(key)) {
                    unionCount += map2.get(key);
                }
            }

            if (unionCount == 0 && overlappingCount == 0) {
                return 65536;
            }

            return overlappingCount * 65536 / unionCount;
        }
        private boolean check(char c) {
            return c >= 'A' && c <= 'Z';
        }
    }

}
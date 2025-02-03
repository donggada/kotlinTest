package com.example.kotlinTest.kakao2018;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Test4_압축 {
    Solution solution = new Solution();
    @Test
    void case1() {
        assertThat(
                solution.solution("KAKAO")
        ).isEqualTo(
                new int[]{11, 1, 27, 15}
        );
    }

    @Test
    void case2() {

        assertThat(
                solution.solution("TOBEORNOTTOBEORTOBEORNOT")
        ).isEqualTo(
                new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}
        );
    }

    @Test
    void case3() {
        assertThat(
                solution.solution("ABABABABABABABAB")
        ).isEqualTo(
                new int[]{1, 2, 27, 29, 28, 31, 30}
        );
    }



    class Solution {
        public int[] solution(String msg) {
            int[] answer = {};
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            int count = 27;
            for (int i = 'A'; i <='Z' ; i++) {
                map.put(String.valueOf((char) i), i - 64);
            }

            for (int i = 0; i < msg.length();) {
                StringBuilder word = new StringBuilder(String.valueOf(msg.charAt(i)));

                while (true) {
                    int length = ++i;

                    if (length >= msg.length()) {
                        result.add(map.get(word.toString()));
                        break;
                    }

                    word.append(msg.charAt(length));
                    String key = word.toString();

                    if (!map.containsKey(key)) {
                        map.put(key, count++);
                        result.add(map.get(key.substring(0, key.length()-1)));
                        break;
                    }
                }

            }

            answer = new int[result.size()];

            for (int i = 0; i < result.size() ; i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }
    }
}

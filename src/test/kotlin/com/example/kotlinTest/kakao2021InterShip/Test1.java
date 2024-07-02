package com.example.kotlinTest.kakao2021InterShip;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Test1 {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution("one4seveneight")
        ).isEqualTo(
                1478
        );
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution("23four5six7")
        ).isEqualTo(
                234567
        );
    }

    @Test
    void cass3() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution("2three45sixseven")
        ).isEqualTo(
                234567
        );
    }

    @Test
    void cass4() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution("123")
        ).isEqualTo(
                123
        );
    }

    class Solution {
        static String[] numString = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight","nine"};
        public int solution(String s) {
            int answer = 0;
            HashMap<String, String> map = new HashMap<>();

            for (int i = 0; i < numString.length ; i++) {
                map.put(numString[i], String.valueOf(i));
            }

            StringBuilder result = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() ; i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    sb.append(c);
                }

                if (map.containsKey(sb.toString())) {
                    result.append(map.get(sb.toString()));
                    sb = new StringBuilder();
                    continue;
                }

                if (c >= '0' && c <= '9') {
                    result.append(c);
                }
            }

            return Integer.parseInt(result.toString());
        }
    }
}

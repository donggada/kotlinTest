package com.example.kotlinTest.프로그래머스.프로그래머스_해시;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest16 {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
            solution.solution(new String[]{"119", "97674223", "1195524421"})
        ).isEqualTo(
            false
        );

        Assertions.assertThat(
            solution.solution(new String[]{"123","456","789"})
        ).isEqualTo(
            true
        );

        Assertions.assertThat(
            solution.solution(new String[]{"12","123","1235","567","88"})
        ).isEqualTo(
            false
        );
    }

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashMap<String, String> map = new HashMap<>();

            for (String phoneNumber : phone_book) {
                map.put(phoneNumber, phoneNumber);
            }

            for (String phoneNumber : phone_book) {
                String key = "";
                for (char c : phoneNumber.toCharArray()) {
                    key += c;
                    if (map.containsKey(key) && map.get(key) != phoneNumber) {
                        return false;
                    }
                }
            }
            return answer;
        }
    }
}

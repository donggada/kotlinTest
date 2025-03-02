
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Test11 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"banana", "apple", "rice", "pork", "pot"},
                        new int[]{3, 2, 2, 2, 1},
                        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
                )
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"apple"},
                        new int[]{10},
                        new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
                )
        ).isEqualTo(
                0
        );
    }

    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < want.length; i++) {
                map.put(want[i], number[i]);
            }

            for (int i = 0; i < discount.length - 9 ; i++) {
                HashMap<String, Integer> mapTemp = new HashMap<>(map);
                for (int j = i; j < i + 10 ; j++) {
                    String key = discount[j];
                    if (mapTemp.containsKey(key)) {
                        Integer count = mapTemp.get(key);

                        if (count == 1) {
                            mapTemp.remove(key);
                            continue;
                        }
                        mapTemp.put(key, count-1);
                    }
                }

                if (mapTemp.isEmpty()) {
                    answer++;
                }
            }

            return answer;
        }
    }

}
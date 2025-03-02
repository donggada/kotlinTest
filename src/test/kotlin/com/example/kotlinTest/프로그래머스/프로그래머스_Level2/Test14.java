
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Test14 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2})
        ).isEqualTo(
                2
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{1, 2, 3, 1, 4})
        ).isEqualTo(
                0
        );
    }

    class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();

            for (int k : topping) {
                map1.put(k, map1.getOrDefault(k,0) + 1);
            }

            for (int k : topping) {
                map2.put(k, map2.getOrDefault(k,0) + 1);

                Integer count = map1.get(k);

                if (count == 1) {
                    map1.remove(k);
                } else {
                    map1.put(k, count -1);
                }

                if (map1.size() == map2.size()) {
                    answer++;
                }
            }
            return answer;
        }
    }

}
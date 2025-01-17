
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Test8 {

    Solution solution = new Solution();
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(6 , new int[]{1, 3, 2, 5, 4, 5, 2, 3})
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})
        ).isEqualTo(
                2
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})
        ).isEqualTo(
                1
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(4, new int[]{1, 2, 3, 4})
        ).isEqualTo(
                4
        );
    }


    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int key : tangerine) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            ArrayList<Integer> reverseList = new ArrayList<>(map.values());
            reverseList.sort(Comparator.reverseOrder());

            for (Integer i : reverseList) {
                if (k <= 0) {
                    return answer;
                }
                k -= i;
                answer++;
            }

            return answer;
        }
    }
}

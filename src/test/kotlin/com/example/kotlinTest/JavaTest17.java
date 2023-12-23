package com.example.kotlinTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest17 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})
        ).isEqualTo(
            5
        );

        Assertions.assertThat(
            solution.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}})
        ).isEqualTo(
            3
        );


    }

    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> map = new HashMap<>();

            for (String[] cloth : clothes) {
                String category = cloth[1];

                Integer count;

                if (map.containsKey(category)) {
                    count = map.get(category);
                    count++;
                } else  {
                    count = 1;
                }

                map.put(category, count);
            }

            for (Integer val : map.values()) {
                answer *= val + 1;
            }


            return answer - 1;
        }
    }

}

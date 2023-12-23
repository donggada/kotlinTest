package com.example.kotlinTest;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest15 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{3, 1, 2, 3})
        ).isEqualTo(2);

        Assertions.assertThat(
            solution.solution(new int[]{3, 3, 3, 2, 2, 4})
        ).isEqualTo(3);

        Assertions.assertThat(
            solution.solution(new int[]{3 ,3, 3, 2, 2, 2})
        ).isEqualTo(2);
    }

    class Solution {
        public int solution(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, num);
            }

            int halfSize = nums.length / 2;

            return Math.min(halfSize, map.keySet().size());
        }
    }

}

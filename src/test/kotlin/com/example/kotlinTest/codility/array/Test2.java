package com.example.kotlinTest.codility.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

public class Test2 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{9, 3, 9, 3, 9, 7, 9})
        ).isEqualTo(
                7
        );
    }



    class Solution {
        public int solution(int[] A) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int key : A) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (Integer key : map.keySet()) {
                if(map.get(key) % 2 == 1) {
                    return key;
                }
            }
            return -1;
        }
    }


}

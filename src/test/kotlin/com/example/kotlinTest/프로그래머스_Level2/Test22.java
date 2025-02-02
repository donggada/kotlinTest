
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test22 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{100,180,360,100,270})
        ).isEqualTo(
                4
        );
    }


    class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            Arrays.sort(weights);

            HashMap<Double, Integer> map = new HashMap<>();

            for (int weight : weights) {
                double a = weight * 1.0;
                double b = weight / 2.0;
                double c = (weight * 2.0) / 3.0;
                double d = (weight * 3.0) / 4.0;

                if (map.containsKey(a)) {
                    answer += map.get(a);
                }

                if (map.containsKey(b)) {
                    answer += map.get(b);
                }

                if (map.containsKey(c)) {
                    answer += map.get(c);
                }

                if (map.containsKey(d)) {
                    answer += map.get(d);
                }

                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            return answer;
        }

    }


}
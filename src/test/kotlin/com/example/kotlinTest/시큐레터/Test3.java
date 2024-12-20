package com.example.kotlinTest.시큐레터;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test3 {

    @Test
    void case1() {
        Assertions.assertThat(
                new Solution().solution(new int[]{1,2,3,0,3})
        ).isEqualTo(2);
    }

    @Test
    void case2() {
        Assertions.assertThat(
                new Solution().solution(new int[]{4,1})
        ).isEqualTo(0);
    }

    class Solution {
        private int count = 0;

        public int solution(int[] foods) {
            int totalSum = Arrays.stream(foods).sum();

            if (totalSum % 3 != 0) {
                return 0;
            }

            int target = totalSum / 3;

            backtrack(foods, 0, target,0, "");
            return count;
        }

        private void backtrack(int[] foods, int index, int target, int sum, String s) {
            if (sum > target) {
                return;
            }

            if (index == foods.length) {
                if (sum == target) {
                    System.out.println(s);
                    count++;
                }
                return;
            }



            if (sum + foods[index] == target) {
                backtrack(foods, index + 1, target, 0, s+ index + "~");
                backtrack(foods, index + 1, target,sum + foods[index],s+ index + "|");
            } else {
                backtrack(foods, index + 1, target, sum + foods[index], s+ index);
            }

        }
    }
}

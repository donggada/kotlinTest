package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest7.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest8 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3)
        ).isEqualTo(3);
    }

    class Solution {
        public int solution(int[] stones, int k) {
            int answer = 0;
            int low = 1;
            int high = 200000;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (check(stones, k, mid)) {
                    low = mid + 1;
                    answer = Math.max(answer, mid);
                } else {
                    high = mid -1;
                }
            }

            return answer;
        }

        private static boolean check(int[] stones, int k, int mid) {
            int count = 0;
            for (int stone : stones) {
                if (stone < mid) {
                    count++;
                } else {
                    count = 0;
                }

                if(count == k) {
                    return false;
                }
            }
            return true;
        }
    }
}

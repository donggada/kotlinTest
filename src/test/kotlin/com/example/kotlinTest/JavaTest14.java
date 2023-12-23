package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest12.Solution;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest14 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{2,5,3,8,1},3,11)
        ).isEqualTo(6);

        Assertions.assertThat(
            solution.solution(new int[]{1,1,2,2},2,3)
        ).isEqualTo(5);

        Assertions.assertThat(
            solution.solution(new int[]{1,2,3,2},2,2)
        ).isEqualTo(0);
    }

    class Solution {

        static int result = 0;
        public int solution(int[] arr , int k ,int t) {

            for (int i = 0; i <arr.length; i++) {
                dp(arr, k, t, 1,1, arr[i]);
            }

            return result;
        }

        static private void dp (int[] arr, int targetK, int index ,int targetN, int k ,int t) {
            if (index >= arr.length) {
                return;
            }
            int count = k + 1;
            int sum = arr[index] + t;

            if (count >= targetK && sum <= targetN) {
                result++;
            }


            dp(arr, targetK, targetN, index + 1, count, sum);
        }
    }

}

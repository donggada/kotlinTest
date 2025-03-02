package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Test39 {

    Solution solution = new Solution();

    @Test
    void case1() {
        assertThat(solution.solution(4)).isEqualTo(11);
    }





    class Solution {
        public int solution(int n) {
            if (n % 2 == 1) {
                return 0;
            }

            int[] dp = new int[n+1];
            dp[2] = 3;

            for (int i = 2; i < n/2+1 ; i++) {
                dp[i*2] = (int) (Math.pow(dp[i], 2) % 1000000007) + factorial(i) ;
            }

            return dp[n];
        }
        private int factorial (int n) {
            int result = 1;
            for (int i = 1; i <= n ; i++) {
                result *= i;
            }
            return result % 1000000007;
        }
    }
}

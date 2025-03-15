package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test45 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        2,4,17
                )
        ).isEqualTo(
                8
        );
    }

    class Solution {
        static String[] arr = {"00000", "11011"};
        public int solution(int n, long l, long r) {
            int answer = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                for(String s : Integer.toBinaryString(i).split("")) {
                       sb.append(arr[Integer.parseInt(s)]);
                }
            }



            for (long i = l-1; i <= r;i++) {
                if (sb.charAt((int) i % sb.length()) == '1') {
                    answer++;
                }
            }
            return answer;
        }
    }
}

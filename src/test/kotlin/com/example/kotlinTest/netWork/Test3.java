package com.example.kotlinTest.netWork;

import com.example.kotlinTest.netWork.Test1.Solution;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {
    int[][] fees = {
        {200, 910, 93},
        {400, 1600, 188},
        {655, 7300, 281},
        {0, 15372, 435}
    };

    int usage = 320;

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
            solution.solution(fees, usage)
        ).isEqualTo(42760);

    }

    class Solution {
        public int solution(int[][] fees, int usage) {
            int answer = 0;
            for (int i = 0; i <fees.length ; i++) {
                int[] feeInfo = fees[i];
                int sum = 0;
                int start = feeInfo[0];
                int end = feeInfo[1];
                if (start < usage) {
                    sum += feeInfo[2];
                } else if (end <= usage) {

                }
            }
            return answer;
        }
    }


}

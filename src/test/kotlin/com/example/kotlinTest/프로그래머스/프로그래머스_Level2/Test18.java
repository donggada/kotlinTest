
package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test18 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new long[]{2, 7})
        ).isEqualTo(
                new long[]{3, 11}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new long[]{10, 11})
        ).isEqualTo(
                new long[]{11, 13}
        );
    }

    class Solution {
        public long[] solution(long[] numbers) {
            int length = numbers.length;
            long[] answer = new long[length];

            for (int i = 0; i < length ; i++) {
                long number = numbers[i];

                if (number % 2 == 0) {
                    answer[i] = number + 1;
                    continue;
                }
                answer[i] = cal(numbers[i]);
            }

            return answer;
        }

        private long cal(long num) {
            String binaryString = Long.toBinaryString(num);

            if (binaryString.contains("0")) {
                int i = binaryString.lastIndexOf("0");
                return Long.parseLong(binaryString.substring(0, i) + "10" + binaryString.substring(i + 2), 2);
            }

            return Long.parseLong(10 + binaryString.substring(1),2);
        }
    }


}
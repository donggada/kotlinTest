package com.example.kotlinTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SocarTest2 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{10,40,30,20}, 20)
        ).isEqualTo(1);

        Assertions.assertThat(
            solution.solution(new int[]{3,7,2,8,6,4,5,1}, 3)
        ).isEqualTo(2);



    }

    class Solution {
        public int solution(int[] numbers, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            int answer = Integer.MAX_VALUE;
            for (int num: numbers) {
                list.add(num);
            }

            for (int index = 0; index < list.size(); index++) {
                Integer num = list.get(index);
                int targetNum1 = num + k;
                int targetNum2 = num - k;

                int index1 = list.indexOf(targetNum1);
                int index2 = list.indexOf(targetNum2);

                if (index1 != -1) {
                    answer = Math.min(answer, (Math.abs(index - index1) -1));
                }

                if (index2 != -1) {
                    answer = Math.min(answer, (Math.abs(index - index2) -1));
                }
            }

            if (answer < -1) {
                answer = -1;
            }
            return answer;
        }

    }
}

package com.example.kotlinTest.프로그래머스_DP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test5 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(new int[]{1, 2, 3, 1})
        ).isEqualTo(4);


    }

    class Solution {
        public int solution(int[] money) {
            int answer = 0;
            int length = money.length;

            if (length == 3) {
                return Arrays.stream(money).max().getAsInt();
            }



            if (length / 2 == 0) {
                return 0;
            }

            if (length / 2 == 1) {
//                처음이랑 끝 1나만 선택가능
                return 0;
            }


            return answer;
        }
    }
}

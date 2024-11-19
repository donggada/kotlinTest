package com.example.kotlinTest.아정당;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {


    @Test
    void case1() {

        Assertions.assertThat(
                new Solution().solution(new String[]{}, new String[]{})
        ).isEqualTo(new int[]{});
    }

    class Solution {
        public int[] solution(String[] items, String[] agreement) {
            int [] answer = {};

            return answer;
        }
    }
}

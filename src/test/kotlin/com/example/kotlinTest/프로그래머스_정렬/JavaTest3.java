package com.example.kotlinTest.프로그래머스_정렬;


import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest3 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{3, 0, 6, 1, 5})
        ).isEqualTo(
            3
        );




    }

    class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int size = citations.length;

            for (int i = 0; i <citations.length ; i++) {
                int citation = citations[i];
                int answer = size - i;
                if (citation >= size - i) {
                    return answer;
                }
            }
            return 0;
        }
    }
}

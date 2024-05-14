package com.example.kotlinTest.house;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Test4 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                      new int[] {5, 3, 4, 4}, 2
           )
        ).isEqualTo(true);


        Assertions.assertThat(
                solution.solution(
                        new int[] {5, 3, 2, 5}, 2
                )
        ).isEqualTo(false);

        Assertions.assertThat(
                solution.solution(
                        new int[] {2, 3,4, 5}, 3
                )
        ).isEqualTo(false);

        Assertions.assertThat(
                solution.solution(
                        new int[] {2, 3, 4, 5, 12, 15}, 3
                )
        ).isEqualTo(true);
    }

    class Solution {
        public boolean solution(int[] cards, int slotSize) {
            int len = cards.length;
            if (len % slotSize != 0) {
                return false;
            }

            Arrays.sort(cards);

            int num  = cards[0];
            int addSize = cards[1] - cards[0];
            for (int i = 0; i < len ; i++) {
                if (i % slotSize == 0) {
                    num = cards[i];
                    addSize = cards[i + 1] - num;
                    if (addSize == 0) {
                        return false;
                    }
                    continue;
                }

                if (cards[i] - num == addSize) {
                    num = cards[i];
                    continue;
                }


                return false;
            }
            return true;
        }


    }
}

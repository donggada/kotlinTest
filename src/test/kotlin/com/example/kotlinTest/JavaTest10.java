package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest9.Solution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest10 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(4, new int[]{3,6,7,2,1,10,5,9,8,12,11,4})
        ).isEqualTo(5);
    }

    class Solution {
        public int solution(int coin, int[] cards) {
            int answer = 0;

            int n = cards.length;
            int rounds = 0;
            Arrays.copyOfRange(cards, 0, n / 3); // 처음에 카드 n/3 개를 가짐

            for (int i = n / 3; i < n; i += 2) {
                int card1 = cards[i];
                int card2 = cards[i + 1];

                // 두 장의 카드의 합이 n + 1이 되도록 선택
                if (card1 + card2 == n + 1) {
                    // 동전이 남아 있으면 사용해서 카드를 가짐
                    if (coin > 0) {
                        coin--;
                        Arrays.copyOfRange(cards, i, i + 2);
                    } else {
                        break; // 동전이 없으면 게임 종료
                    }
                } else {
                    // 두 장의 카드의 합이 n + 1이 아니면 카드를 버림
                    Arrays.copyOfRange(cards, i, i + 2);
                }

                rounds++;
            }

            return rounds;
        }
    }

}

package com.example.kotlinTest.kakao_2023_blind_recruitment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1_이모티콘할인행사 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new int[][]{{40, 10000}, {25, 10000}},
                        new int[]{7000, 9000}
                )
        ).isEqualTo(
                new int[]{1,5400}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                        new int[]{1300, 1500, 1600, 4900}
                )
        ).isEqualTo(
                new int[]{4,13860}
        );
    }

    class Solution {
        static int[] discount = {10,20,30,40};
        static int maxOfSubscribe;
        static int maxOfCost;
        public int[] solution(int[][] users, int[] emoticons) {
            dfs(0, emoticons.length, new int[emoticons.length],users,emoticons);
            return new int[]{maxOfSubscribe, maxOfCost};
        }

        public void dfs(int index, int emoticonsLength, int[] discounts, int[][] users, int[] emoticons) {
            if (index == emoticonsLength) {
                int subscribe = 0;
                int cost = 0;

                for (int[] user : users) {
                    int userDiscountRate = user[0];
                    int userMaxCost = user[1];

                    int sum = 0;

                    for (int i = 0; i < emoticons.length; i++) {
                        if (discounts[i] >= userDiscountRate) {
                            sum += emoticons[i] / 100 * (100 - discounts[i]);
                        }
                    }

                    if (sum >= userMaxCost) {
                        subscribe++;
                        continue;
                    }

                    cost += sum;
                }


                if (subscribe > maxOfSubscribe) {
                    maxOfSubscribe = subscribe;
                    maxOfCost = cost;
                    return;
                }

                if (subscribe == maxOfSubscribe) {
                    maxOfCost = Math.max(maxOfCost, cost);
                }

                return;
            }
            for (int i = 0; i < 4; i++) {
                discounts[index] = discount[i];
                dfs(index + 1, emoticonsLength, discounts, users, emoticons);
            }
        }
    }



}

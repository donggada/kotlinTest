package com.example.kotlinTest.pccp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test1 {

    @Test
    void case1() {
        Solution solution = new Solution();

        assertThat(
                solution.solution(new int[]{5 ,1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}})
        ).isEqualTo(
                5
        );
    }

    @Test
    void case2() {
        Solution solution = new Solution();

        assertThat(
                solution.solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}})
        ).isEqualTo(
                -1
        );
    }

    @Test
    void case3() {
        Solution solution = new Solution();

        assertThat(
                solution.solution(new int[]{4 ,2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}})
        ).isEqualTo(
                -1
        );
    }

    @Test
    void case4() {
        Solution solution = new Solution();

        assertThat(
                solution.solution(new int[]{1 ,1, 1}, 5, new int[][]{{1,2}, {3, 2}})
        ).isEqualTo(
                3
        );
    }

    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int finalHealth = health;

            int beforeTime = 0;
            for (int[] attack : attacks) {
                int time = attack[0];
                int damage = attack[1];

                int plusHealth =  (time - beforeTime -1) * bandage[1];
                int bonusHealth = (time - beforeTime -1) / bandage[0] * bandage[2];


                finalHealth = Math.min(finalHealth + plusHealth + bonusHealth, health);
                finalHealth -= damage;

                if (finalHealth < 1) {
                    return -1;
                }

                beforeTime = attack[0];

            }
            return finalHealth;
        }
    }
}

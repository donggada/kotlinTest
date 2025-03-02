

package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Test28 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                      7,3, new int[]{4, 2, 4, 5, 3, 3, 1}
                )
        ).isEqualTo(
                5
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        2,4, new int[]{3, 3, 3, 3}
                )
        ).isEqualTo(
                4
        );
    }


    class Solution {
        public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int i = 0; i < enemy.length; i++) {
                queue.add(enemy[i]);

                if (queue.size() > k) {
                    n -= queue.poll();
                }

                if (n < 0) {
                    return i;
                }
            }
            return enemy.length;
        }

    }

}
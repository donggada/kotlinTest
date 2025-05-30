package com.example.kotlinTest.codility.stackAndQueue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Stack;

public class Test2 {
    private final Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
            solution.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0})
        ).isEqualTo(2);
    }

    class Solution {
        private static final int UPSTREAM = 0;

        public int solution(int[] fishSizes, int[] fishDirections) {
            Stack<Integer> downstreamFish = new Stack<>();
            int upstreamSurvivors = 0;

            for (int i = 0; i < fishSizes.length; i++) {
                int fishSize = fishSizes[i];
                int direction = fishDirections[i];

                if (direction == UPSTREAM) {
                    if (canSurviveUpstream(fishSize, downstreamFish)) {
                        upstreamSurvivors++;
                    }
                    continue;
                }

                downstreamFish.push(fishSize);
            }

            return upstreamSurvivors + downstreamFish.size();
        }

        private boolean canSurviveUpstream(int fishSize, Stack<Integer> downstreamFish) {
            while (!downstreamFish.isEmpty()) {
                if (downstreamFish.peek() > fishSize) {
                    return false;
                }
                downstreamFish.pop();
            }
            return true;
        }
    }
}

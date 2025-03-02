package com.example.kotlinTest.프로그래머스.프로그래머스_스택_큐;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test6 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{1, 2, 3, 2, 3})
        ).isEqualTo(
            new int[]{4, 3, 1, 1, 0}
        );

    }


    class Solution {
        public int[] solution(int[] prices) {
            int length = prices.length;
            int[] answer = new int[length];
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < prices.length ; i++) {
                int price = prices[i];
                if (stack.isEmpty()) {
                    stack.add(new int[]{i, price});
                    continue;
                }

                while (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    if (peek[1] <= price) {
                        break;
                    }
                    int index = stack.pop()[0];
                    answer[index] = i - index;
                }

                stack.add(new int[]{i, price});
            }

            while (!stack.isEmpty()) {
                int index = stack.pop()[0];
                answer[index] = length - index - 1;
            }

            return answer;
        }
    }
}

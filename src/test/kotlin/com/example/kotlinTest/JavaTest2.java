package com.example.kotlinTest;


import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest2 {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
            solution.solution(new int[]{2, 3, 3, 5})
        ).isEqualTo(new int[]{3, 5, 5, -1});
//

        Assertions.assertThat(
            solution.solution(new int[]{9, 1, 5, 3, 6, 2})
        ).isEqualTo(new int[]{-1, 5, 6, 6, -1, -1});


    }

    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();

            stack.push(0);
            for (int index = 1; index <numbers.length ; index++) {

                while (!stack.isEmpty() && numbers[index] > numbers[stack.peek()]) {
                    answer[stack.pop()] = numbers[index];
                }

                stack.push(index);
            }

            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }
            return answer;
        }
    }
}

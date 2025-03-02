package com.example.kotlinTest.프로그래머스.프로그래머스_스택_큐;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.ImageIcon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(new int[]{1, 1, 3, 3, 0, 1, 1})).isEqualTo(new int []{1, 3, 0, 1});
        Assertions.assertThat(solution.solution(new int[]{4, 4, 4, 3, 3})).isEqualTo(new int []{4, 3});

    }


    public class Solution {
        public int[] solution(int [] arr) {
            Stack<Integer> stack = new Stack<>();

            stack.add(arr[0]);

            for (int i = 1; i <arr.length; i++) {
                int num = arr[i];
                if (stack.peek() != num) {
                    stack.add(num);
                }
            }

            int[] answer = new int[stack.size()];

            for (int i = 0; i <stack.size() ; i++) {
                answer[i] = stack.get(i);
            }

            return answer;
        }
    }
}

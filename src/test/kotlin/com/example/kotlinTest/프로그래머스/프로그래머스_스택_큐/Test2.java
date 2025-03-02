package com.example.kotlinTest.프로그래머스.프로그래머스_스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})
        ).isEqualTo(
            new int []{2, 1}
        );


        Assertions.assertThat(
            solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})
        ).isEqualTo(
            new int []{1, 3, 2}
        );


    }


    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> list = new ArrayList<>();
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++) {
                int n = 100 - progresses[i];
                int speed = speeds[i];
                int addN;

                if (n % speed == 0) {
                    addN = (n / speed);
                } else {
                    addN = (n / speed + 1);
                }

                if (queue.isEmpty()) {
                    queue.add(addN);
                } else {
                    if (queue.peek() >= addN) {
                        queue.add(addN);
                    } else {
                        list.add(queue.size());
                        queue.clear();
                        queue.add(addN);
                    }
                }
            }

            if (!queue.isEmpty()) {
                list.add(queue.size());
            }


            int[] answer = new int[list.size()];

            for (int i = 0; i <list.size() ; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}

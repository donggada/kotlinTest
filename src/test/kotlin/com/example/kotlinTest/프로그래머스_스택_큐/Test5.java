package com.example.kotlinTest.프로그래머스_스택_큐;

import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test5 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(2, 10 ,new int[]{7, 4, 5, 6})
        ).isEqualTo(
            8
        );

        Assertions.assertThat(
            solution.solution(100, 100 ,new int[]{10})
        ).isEqualTo(
            101
        );

        Assertions.assertThat(
            solution.solution(100, 100 ,new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})
        ).isEqualTo(
            110
        );



    }


    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            LinkedList<Integer> queue = new LinkedList<>();
            int truckSum = 0;
            int answer = 0;


            for (int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];

                while (true) {
                    if (queue.isEmpty()) {
                        queue.add(truck);
                        truckSum += truck;
                        answer++;
                        break;
                    } else if (queue.size() == bridge_length) {
                        truckSum -= queue.poll();
                    } else {
                        if (truckSum + truck <= weight) {
                            queue.add(truck);
                            truckSum += truck;
                            answer++;
                            break;
                        } else {
                            queue.add(0);
                            answer++;
                        }
                    }
                }
            }

            return answer + bridge_length;
        }
    }
}

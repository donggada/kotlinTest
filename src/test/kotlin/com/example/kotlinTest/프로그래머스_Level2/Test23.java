
package com.example.kotlinTest.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test23 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new String[][]{
                        {"15:00", "17:00"},
                        {"16:40", "18:20"},
                        {"14:20", "15:20"},
                        {"14:10", "19:20"},
                        {"18:20", "21:20"}
                })
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[][]{
                        {"09:10", "10:10"},
                        {"10:20", "12:20"}
                })
        ).isEqualTo(
                1
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new String[][]{
                        {"10:20", "12:30"},
                        {"10:20", "12:30"},
                        {"10:20", "12:30"}
                })
        ).isEqualTo(
                3
        );
    }


    class Solution {
        public int solution(String[][] book_time) {
            Arrays.sort(book_time, (arr1, arr2) -> arr1[0].equals(arr2[0]) ? arr1[1].compareTo(arr2[1]) : arr1[0].compareTo(arr2[0]));

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (String[] bk : book_time) {
                if (queue.isEmpty()) {
                    queue.add(plus10MinOf(bk[1]));
                    continue;
                }

                if (queue.peek() <= IntegerOf(bk[0])) {
                    queue.poll();
                }

                queue.add(plus10MinOf(bk[1]));
            }

            return queue.size();
        }

        private int plus10MinOf(String time) {
            String[] arr = time.split(":");
            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);

            return ((hour + ((min + 10) / 60)) * 100) + ((min + 10) % 60);
        }

        private int IntegerOf(String time) {
            String[] arr = time.split(":");
            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);

            return hour * 100 + min % 60;
        }

    }


}
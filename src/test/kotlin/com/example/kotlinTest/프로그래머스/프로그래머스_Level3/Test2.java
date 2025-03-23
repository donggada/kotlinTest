package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test2 {

    Solution solution = new Solution();


    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})
        ).isEqualTo(
                new int[]{0, 0}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})
        ).isEqualTo(
                new int[]{333, -45}
        );
    }

    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            ArrayList<Integer> list = new ArrayList<>();
            for (String op : operations) {
                if (op.equals("D 1")) {
                    if (!list.isEmpty()) {
                        list.sort(Collections.reverseOrder());
                        list.remove(0);
                    }
                    continue;
                }

                if (op.equals("D -1")) {
                    if (!list.isEmpty()) {
                        Collections.sort(list);
                        list.remove(0);
                    }
                    continue;
                }

                list.add(Integer.parseInt(op.split(" ")[1]));
            }

            if (list.size() > 1) {
                list.sort(Collections.reverseOrder());
                answer[0] = list.get(0);
                answer[1] = list.get(list.size()-1);
            }

            if (list.size() == 1) {
                answer[0] = list.get(0);
            }


            return answer;
        }
    }

}

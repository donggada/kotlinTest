package com.example.kotlinTest.프로그래머스_탐욕법;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test3 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new int[]{70, 50, 80, 50}, 100)
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new int[]{70, 80, 50}, 100)
        ).isEqualTo(
                3
        );
    }

    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            List<Integer> peopleList = new ArrayList<>();
            Arrays.stream(people).forEach(peopleList::add);
            peopleList.sort(Collections.reverseOrder());

            int backIndex = peopleList.size() - 1;

            for (int i = 0; i <= backIndex; i++) {
                if (peopleList.get(i) + peopleList.get(backIndex) <= limit) {
                    answer++;
                    backIndex--;
                    continue;
                }

                answer++;
            }

            return answer;
        }
    }
}

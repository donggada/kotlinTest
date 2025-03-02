package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class Test4 {
    @Test
    void case1() {
        assertThat(new Solution().solution(new int[]{4, 3, 1, 2, 5})).isEqualTo(2);
    }

    @Test
    void case2() {
        assertThat(new Solution().solution(new int[]{5, 4, 3, 2, 1})).isEqualTo(5);
    }


    class Solution {
        public int solution(int[] order) {
            List<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            HashSet<Integer> set = new HashSet<>();
            int index = 1;
            for (int i = 0; i < order.length ; i++) {
                int num = order[i];

                for (int j = index; j <= num; j++) {
                    if (!set.contains(j)) {
                        stack.add(j);
                    }
                    set.add(j);
                }

                index = num;

                if (stack.peek() == num) {
                    result.add(stack.pop());
                    continue;
                }
                break;
            }


            return result.size();
        }
    }
}

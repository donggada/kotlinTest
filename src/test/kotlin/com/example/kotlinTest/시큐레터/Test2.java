package com.example.kotlinTest.시큐레터;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test2 {

    @Test
    void case1() {
        Assertions.assertThat(
                new Solution().solution(4)
        ).isEqualTo(9);
    }

    @Test
    void case2() {
        Assertions.assertThat(
                new Solution().solution(11)
        ).isEqualTo(31);
    }

    class Solution {
        public long solution(long n) {
            ArrayList<Long> list = new ArrayList<>();
            Long num = 1L;
            list.add(1L);
            while (list.size()-1 < n ) {
                num *= 3;
                list.add(num);
                int size = list.size();
                for (int i = 0; i <size-1; i++) {
                    list.add(list.get(i) + num);
                }

            }

            return list.get((int) (n-1));
        }
    }
}

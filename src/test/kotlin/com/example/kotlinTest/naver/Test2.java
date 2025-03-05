package com.example.kotlinTest.naver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

public class Test2 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(11)
        ).isEqualTo(
                "dba"
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(1)
        ).isEqualTo(
                "a"
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(67108876)
        ).isEqualTo(
                "zzdc"
        );
    }


    class Solution {
        public String solution(int N) {
            StringBuffer sb = new StringBuffer();
            HashMap<Integer, String> map = new HashMap<>();
            int key = 1;
            char value = 'a';
            for (int i = 0; i < 26; i++) {
                map.put(key, String.valueOf(value));
                key *= 2;
                value +=1;
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            list.sort(Comparator.reverseOrder());

            int index = 0;
            while (N != 0) {
                Integer val = list.get(index);
                int count = N / val;
                N %= val;
                for (int j = 0; j < count ; j++) {
                    sb.append(map.get(val));
                }
                index++;
            }

            return sb.toString();
        }
    }
}

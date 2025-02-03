package com.example.kotlinTest.kakao2018;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test2_캐쉬 {


    @Test
    void  test1 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(3,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})
        ).isEqualTo(50);
    }

    @Test
    void  test2 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(3,
                        new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})
        ).isEqualTo(21);
    }

    @Test
    void  test3 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(2,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})
        ).isEqualTo(60);
    }

    @Test
    void  test4 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(5,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})
        ).isEqualTo(52);
    }

    @Test
    void  test5 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(2,
                        new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})
        ).isEqualTo(16);
    }

    @Test
    void  test6 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(0,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})
        ).isEqualTo(25);
    }

    @Test
    void  test7 () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(2,
                        new String[]{"Jeju", "Jeju1", "Jeju", "Jeju1", "Jeju"})
        ).isEqualTo(13);
    }




    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            if (cacheSize == 0) {
                return cities.length * 5;
            }

            Queue<String> cache = new LinkedList<>();

            for (String keyWord: cities) {
                String lowerCase = keyWord.toLowerCase();

                if (cache.remove(lowerCase)) {
                    cache.add(lowerCase);
                    answer += 1;
                } else {
                    if (cache.size() == cacheSize) {
                        cache.poll();
                        cache.add(lowerCase);
                    } else {
                        cache.add(lowerCase);
                    }
                    answer += 5;
                }
            }

            return answer;
        }
    }
}

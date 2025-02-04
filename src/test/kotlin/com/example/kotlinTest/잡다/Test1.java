package com.example.kotlinTest.잡다;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Test1 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(7,
                        new int[][]{
                                {1, 1}, {1, 21}, {1, 22}, {1, 23},
                                {3, 1},
                                {5, 5}, {5, 27},
                                {6, 6},
                                {8, 15},
                                {9, 28}, {9, 29}, {9, 30},
                                {10, 3}, {10, 9},
                                {12, 25}
                        },
                        5)
        ).isEqualTo(
                new int[]{5,6,6,5,4,5,5,4,5,5,6,5}
        );
    }
    class Solution {
        static int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        static HashSet<Integer> offDay;
        public int[] solution(int X, int[][] H, int Y) {
            int[] answer = new int[12];
            offDay = new HashSet<>();
            HashSet<Integer> payDay = new HashSet<>();

            for (int[] d : H) {
                int day = 0;

                for (int j = 1; j < d[0]; j++) {
                    day += lastDay[j - 1];
                }
                day += d[1];
                offDay.add(day);
            }

            for (int i = 0; i <lastDay.length ; i++) {
                int day = 0;
                for (int j = 0; j < i; j++) {
                    day += lastDay[j];
                }

                payDay.add(day+Y);
            }

            int month = 0;
            for (int i = 1; i <= 365; i++) {
                int currentDayOfWeek = (X + (i -1)) % 7;

                if(payDay.contains(i)){
                    if (!offDay.contains(i) && currentDayOfWeek != 0 && currentDayOfWeek != 6) {
                        answer[month] = Y;
                        month++;
                        continue;
                    }
                    answer[month] = findPayDay(X, i, Y);
                    month++;
                }

            }

            return answer;
        }

        private int findPayDay(int X, int day, int Y) {
            int day1 = day;
            int day2 = day;
            while (true) {
                day1++;
                day2--;

                if (!offDay.contains(day2) && (X + (day2 -1)) % 7 != 6 && (X + (day2 -1)) % 7 != 0) {
                    return Y - (day - day2);
                }

                if (!offDay.contains(day1) && (X + (day1 -1)) % 7 != 6 && (X + (day1 -1)) % 7 != 0) {
                    return Y + (day1 -day);
                }
            }

        }

    }
}

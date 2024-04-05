package com.example.kotlinTest.kakaomobility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test3 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(
                2,
                "1A 2F 1C"
        )).isEqualTo(2);

        Assertions.assertThat(solution.solution(
                1,
                ""
        )).isEqualTo(2);

        Assertions.assertThat(solution.solution(
                22,
                "1A 3C 2B 20G 5A"
        )).isEqualTo(41);


    }

    class Solution {

        HashSet<Integer> firstSeat = new HashSet<Integer>(Arrays.asList(1,3,5));
        public int solution(int N, String S) {
            boolean[][] seatsMap = new boolean[N][10];

            if (!S.isEmpty()) {
                String[] reservedSeatArray = S.split(" ");

                for (String seat : reservedSeatArray) {
                    int row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
                    int col = seat.charAt(seat.length() - 1) - 'A';
                    seatsMap[row][col] = true;
                }
            }


            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 7; j++) {

                    if (firstSeat.contains(j)) {
                        if (seatsMap[i][j] || seatsMap[i][j + 1] || seatsMap[i][j + 2] || seatsMap[i][j + 3]) {
                            continue;
                        }
                        seatsMap[i][j] = true;
                        seatsMap[i][j + 1] = true;
                        seatsMap[i][j + 2] = true;
                        seatsMap[i][j + 3] = true;
                        count++;
                    }

                }

            }

            return count;
        }
    }

}

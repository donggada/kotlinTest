package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest9.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest12 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(6,1)
        ).isEqualTo(new int[]{1,0,0,1,0,0,1,0,0,1,0,0});

        Assertions.assertThat(
            solution.solution(6,25)
        ).isEqualTo(new int[]{0,1,1,0,0,1,0,0,0,0,1,0});
    }

    class Solution {

        static int[] dayArray = {31,28,31,30,31,30,31,31,30,31,30,31};
        static List<Integer> weekdayList = Arrays.asList(1,2,3,4);
        static List<Integer> dayOffList = Arrays.asList(5,6);

        public int[] solution(int day , int k) {
            int size = dayArray.length;
            int [] answer = new int[size];

            int initDay = (day + ((k % 7) - 1)) % 6 -1;
            System.out.println("initDay = " + initDay);
            for (int i = 0; i < size; i++) {
                initDay = initDay + ((dayArray[i] % 7) % 6);

                if (weekdayList.contains(initDay)) {
                    answer[i] = 0;
                }

                if(dayOffList.contains(initDay)) {
                    answer[i] = 1;
                }
            }
            return answer;
        }
    }
}

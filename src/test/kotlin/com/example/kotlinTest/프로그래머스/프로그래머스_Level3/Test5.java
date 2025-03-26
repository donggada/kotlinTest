package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test5 {

    Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(11, new int[]{4,11}, 1)
        ).isEqualTo(
                3
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(16, new int[]{9}, 2)
        ).isEqualTo(
                3
        );
    }


    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(16, new int[]{3,9}, 2)
        ).isEqualTo(
                2
        );
    }

    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;

            for(int i = 0; i <= stations.length; i++) {
                if(i == 0) {
                    answer += cal(stations[i] - 1 - w, w);
                    continue;
                }

                if(i == stations.length) {
                    answer += cal(n - stations[i-1] - w, w);
                    continue;
                }

                answer += cal(stations[i] - stations[i-1] - (w * 2) -1, w);
            }
            return answer;
        }
        
        private int cal (int difference, int w) {
            int result = 0;
            if (difference >= 0) {
                int s = w * 2 + 1;
                result += difference / s;
                result += difference % s == 0 ? 0 : 1;
            }
            return result;
        }
    }
}

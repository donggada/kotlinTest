package com.example.kotlinTest.kakao2018;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test3 {

    @Test
    void case1() {
        Solution solution = new Solution();
        assertThat(solution.solution("1S2D*3T")).isEqualTo(37);
    }
    @Test
    void case2() {
        Solution solution = new Solution();
        assertThat(solution.solution("1D2S#10S")).isEqualTo(9);
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        assertThat(solution.solution("1D2S0T")).isEqualTo(3);
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        assertThat(solution.solution("1S*2T*3S")).isEqualTo(23);
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        assertThat(solution.solution("1D#2S*3S")).isEqualTo(5);
    }

    @Test
    void case6() {
        Solution solution = new Solution();
        assertThat(solution.solution("1T2D3D#")).isEqualTo(-4);
    }

    @Test
    void case7() {
        Solution solution = new Solution();
        assertThat(solution.solution("1D2S3T*")).isEqualTo(59);
    }

    class Solution {
        public int solution(String dartResult) {

            int score = 0;
            int[] scoreArray = new int[3];
            int scoreIndex = 0;
            StringBuilder numString = new StringBuilder();
            for (int i = 0; i < dartResult.length() ; i++) {
                char c = dartResult.charAt(i);


                if (c >= '0' && c <= '9') {
                    numString.append(c);
                }

                if (isNotScore(c)) {
                    score = Integer.parseInt(numString.toString());
                    numString = new StringBuilder();
                }


                if (c == 'S') {
                    scoreArray[scoreIndex] = (int) Math.pow(score, 1);
                    scoreIndex++;
                }

                if (c == 'D') {
                    scoreArray[scoreIndex] = (int) Math.pow(score, 2);
                    scoreIndex++;
                }

                if (c == 'T') {
                    scoreArray[scoreIndex] = (int) Math.pow(score, 3);
                    scoreIndex++;
                }


                if (c == '*') {
                    scoreArray[scoreIndex -1] *= 2;
                    if (scoreIndex > 1) {
                        scoreArray[scoreIndex -2] *= 2;
                    }
                }

                if (c == '#') {
                    scoreArray[scoreIndex-1] *= -1;
                }

            }
            return scoreArray[0] + scoreArray[1] + scoreArray[2];
        }


        private boolean isNotScore(char c) {
            return c == 'S' || c == 'D' || c == 'T';
        }
    }


}

package com.example.kotlinTest.kakao2018;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Test1_비밀지도 {
    Solution solution = new Solution();
    @Test
    void test1 () {

        assertThat(
                solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})
        ).isEqualTo(
                new String[]{"#####","# # #", "### #", "# ##", "#####"}
        );
    }

    @Test
    void test2 () {

        assertThat(
                solution.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})
        ).isEqualTo(
                new String[]{"######", "### #", "## ##", " #### ", " #####", "### # "}
        );
    }

    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];



            for (int i = 0; i < n ; i++) {
                String num1 = Integer.toBinaryString(arr1[i]);
                String num2 = Integer.toBinaryString(arr2[i]);


                int zeroCount1 = n - num1.length();
                int zeroCount2 = n - num2.length();

                int[] num1Arr = new int[n];
                int[] num2Arr = new int[n];

                for (int j = 0; j < num1.length() ; j++) {
                    num1Arr[zeroCount1 + j] = num1.charAt(j) - 48;
                }

                for (int j = 0; j < num2.length() ; j++) {
                    num2Arr[zeroCount2 + j] = num2.charAt(j) - 48;
                }

                StringBuilder sb = new StringBuilder();
                boolean isLastNotEmpty = true;
                for (int j = 0; j < n ; j++) {
                    if (num1Arr[j] == num2Arr[j] && num1Arr[j] == 0) {
                        if (!isLastNotEmpty) {
                            continue;
                        }
                        sb.append(" ");
                        isLastNotEmpty = false;
                        continue;
                    }
                    sb.append("#");
                    isLastNotEmpty = true;
                }
                answer[i] = sb.toString();
            }
            return answer;
        }
    }
}

package com.example.kotlinTest.kakao2018;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class Test5 {
    Solution solution = new Solution();
    @Test
    void case1() {
        assertThat(
                solution.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})
        ).isEqualTo(
                new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}
        );
    }

    @Test
    void case2() {
        assertThat(
                solution.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})
        ).isEqualTo(
                new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"}
        );
    }

    class Solution {
        public String[] solution(String[] files) {
            String[] answer = {};

            String[][] arr = new String[files.length][3];

            for (int i = 0; i < files.length; i++) {
                String file = files[i];
                int index = 0;
                StringBuilder headSb = new StringBuilder();
                StringBuilder numberSb = new StringBuilder();
                StringBuilder taliSb = new StringBuilder();
                for (int j = 0; j < file.length(); j++) {
                    char c = file.charAt(j);

                    if (!isNumber(c) && index == 0) {
                        headSb.append(c);
                        continue;
                    }

                    if (isNumber(c) && index == 0) {
                        index++;
                    }


                    if (isNumber(c) && index == 1) {
                        numberSb.append(c);
                        continue;
                    }

                    if (!isNumber(c) && index == 1) {
                        index++;
                    }

                    taliSb.append(c);
                }
                arr[i][0] = headSb.toString();
                arr[i][1] = numberSb.toString();
                arr[i][2] = taliSb.toString();

            }

            Arrays.sort(arr,
                    (arr1, arr2) ->
                            Objects.equals(arr1[0].toUpperCase(), arr2[0].toUpperCase()) ?
                                    Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]) : arr1[0].toUpperCase().compareTo(arr2[0].toUpperCase()));

            answer = new String[files.length];

            for (int i = 0; i < files.length ; i++) {
                answer[i] = arr[i][0] + arr[i][1] + arr[i][2];
            }

            return answer;
        }

        private boolean isNumber(char c) {
            return c >= '0' && c <= '9';
        }
    }
}

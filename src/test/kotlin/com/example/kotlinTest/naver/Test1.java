package com.example.kotlinTest.naver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Test1 {

    Solution solution = new Solution();



    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("123-123-123")
        ).isEqualTo(
                true
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution("123 123 123")
        ).isEqualTo(
                false
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution("123-123-1234")
        ).isEqualTo(
                false
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution("011-501-511")
        ).isEqualTo(
                true
        );
    }

    @Test
    void case5() {
        Assertions.assertThat(
                solution.solution("123-abc-123")
        ).isEqualTo(
                false
        );
    }


    class Solution {
        public boolean solution(String S) {
            String[] numArray = S.split("-");
            if (numArray.length != 3) {
                return false;
            }

            for (String num : numArray) {
                if (num.length() != 3) {
                    return false;
                }
                for (int i = 0; i <num.length() ; i++) {
                    char c = num.charAt(i);
                    if (!(c >= '0' && c <= '9')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

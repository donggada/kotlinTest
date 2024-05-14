package com.example.kotlinTest.kakao2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 신규아이디추천 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                        "...!@BaT#*..y.abcdefghijklm"
                )
        ).isEqualTo("bat.y.abcdefghi");

        Assertions.assertThat(
                solution.solution(
                        "z-+.^."
                )
        ).isEqualTo("z--");

        Assertions.assertThat(
                solution.solution(
                        "=.="
                )
        ).isEqualTo("aaa");

        Assertions.assertThat(
                solution.solution(
                        "123_.def"
                )
        ).isEqualTo("123_.def");

        Assertions.assertThat(
                solution.solution(
                        "abcdefghijklmn.p"
                )
        ).isEqualTo("abcdefghijklmn");
    }



    class Solution {
        public String solution(String new_id) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < new_id.length(); i++) {
                char c = new_id.charAt(i);

                if(answer.length()==15){
                    break;
                } else if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                    answer.append(String.valueOf(c).toLowerCase());
                }else if(Character.isDigit(c)){
                    answer.append(c);
                } else if (!answer.isEmpty() && i != 0 && i != new_id.length() - 1 && c == '.'&& answer.charAt(answer.length() - 1) != '.') {
                    answer.append(c);
                } else if (c == '-') {
                    answer.append(c);
                } else if (c == '_') {
                    answer.append(c);
                }

            }

            while (answer.length()<3 || answer.charAt(answer.length()-1) == '.'){
                if (answer.length() < 3 && answer.toString().isEmpty()) {
                    answer.append("a");
                } else if (answer.charAt(answer.length() - 1) == '.') {
                    answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                } else if (answer.length() < 3) {
                    answer.append(answer.charAt(answer.length() - 1));
                }
            }

            return answer.toString();
        }
    }



}

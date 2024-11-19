package com.example.kotlinTest.가비아;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test20241015_2 {



    @Test
    void case1() {

        Assertions.assertThat(
                new Solution().solution(
                        new String[]{"8 1","10","7 0","6 4","0 8","8 2","10","9 0","0 10","8 2 5"}
                )
        ).isEqualTo(
                new String[] {
                        "8 1","X","7 -","6 /","- 8","8 /","X","9 -","- /","8 / 5"
                }
        );

    }

    @Test
    void case2() {

        Assertions.assertThat(
                new Solution().solution(
                        new String[]{"8 2","10","10","10","10","10","10","10","10","10 10 10"}
                )
        ).isEqualTo(
                new String[] {
                        "8 /","X","X","X","X","X","X","X","X","X X X"
                }
        );

    }

    @Test
    void case3() {

        Assertions.assertThat(
                new Solution().solution(
                        new String[]{"8 2","10","10","10","10","10","10","10","10","1 8"}
                )
        ).isEqualTo(
                new String[] {
                        "8 /","X","X","X","X","X","X","X","X","1 86"
                }
        );

    }

    class Solution {
        public String[] solution(String[] Frame) {
            int size = 10;
            String[] answer = new String[size];

            for (int i = 0; i < size; i++) {
                String[] sp = Frame[i].split(" ");


                if (sp.length == 1) {
                    answer[i] = "X";
                    continue;
                }

                int score = 10;
                StringBuffer s = new StringBuffer();

                for (int j = 0; j < sp.length; j++) {
                    int n = Integer.parseInt(sp[j]);
                    score -= n;

                    if (n > 0 && n < 10 && score == 0) {
                        s.append("/");
                    }

                    if (n > 0 && n < 10 && score != 0) {
                        s.append(sp[j]);
                    }

                    if (n == 0) {
                        s.append("-");
                    }

                    if (n == 10) {

                        if (i % 2 == 0) {
                            s.append("/");
                        }

                        if (i % 2 == 1) {
                            s.append("X");
                        }

//                        if (score == 10) {
//                            s.append("X");
//                            score = 10;
//                        } else {
//                            s.append("/");
//                            score -= n;
//                        }

                    }

                    if (j == 1) {
                        score = 10;
                    }

                    if (j != sp.length - 1) {
                        s.append(" ");
                    }


                }

                answer[i] = s.toString();

            }
            return answer;
        }
    }
}

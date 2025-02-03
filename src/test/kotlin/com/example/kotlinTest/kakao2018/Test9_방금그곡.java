
package com.example.kotlinTest.kakao2018;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

public class Test9_방금그곡 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        "ABCDEFG",
                        new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}
                )
        ).isEqualTo(
                "HELLO"
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        "CC#BCC#BCC#BCC#B",
                        new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}
                        )
        ).isEqualTo(
                "FOO"
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        "ABC",
                        new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}
                )
        ).isEqualTo(
                "WORLD"
        );
    }

    @Test
    void case4() {
        Assertions.assertThat(
                solution.solution(
                        "ABC",
                        new String[]{"12:00,12:04,HELLO,ABC#"}
                )
        ).isEqualTo(
                "(None)"
        );
    }

    @Test
    void case5() {
        Assertions.assertThat(
                solution.solution(
                        "ABC#",
                        new String[]{"12:00,12:04,HELLO,ABC#"}
                )
        ).isEqualTo(
                "HELLO"
        );
    }

    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            m = changeMelody(m);
            long maxMin = -1;
            for (String musicinfo : musicinfos) {
                String[] music = musicinfo.split(",");
                String melody = changeMelody(music[3]);
                int length = melody.length();
                long min = cal(music[0], music[1]);

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < min / length; j++) {
                    sb.append(melody);
                }

                for (int j = 0; j < min % length; j++) {
                    sb.append(melody.charAt(j));
                }

                if (sb.toString().contains(m)) {
                    if (maxMin < min) {
                        maxMin = min;
                        answer = music[2];
                    }
                }
            }

            if (maxMin == -1) {
                return "(None)";
            }

            return answer;
        }

        private long cal (String start, String end) {
            String[] startArr = start.split(":");
            String[] endArr = end.split(":");
            return Duration.between(
                    LocalTime.of(Integer.parseInt(startArr[0]), Integer.parseInt(startArr[1])),
                    LocalTime.of(Integer.parseInt(endArr[0]), Integer.parseInt(endArr[1]))
            ).toMinutes();
        }

        private String changeMelody(String melody) {
            return melody.replaceAll("C#", "c")
                    .replaceAll("D#", "d")
                    .replaceAll("F#", "f")
                    .replaceAll("G#", "g")
                    .replaceAll("A#", "a");

        }
    }
}
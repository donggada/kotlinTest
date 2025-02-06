

package com.example.kotlinTest.프로그래머스_Level2;

import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Test31 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new String[][]{{"korean", "11:40", "30"},{"english", "12:10", "20"}, {"math", "12:30", "40"}}
                )

        ).isEqualTo(
                new String[]{"korean", "english", "math"}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}
                )

        ).isEqualTo(
                new String[]{"science", "history", "computer", "music"}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}
                )

        ).isEqualTo(
                new String[]{"bbb", "ccc", "aaa"}
        );
    }


    class Solution {
        public String[] solution(String[][] plans) {
            Stack<String> subjectStack = new Stack<>();
            Stack<Long> useTimestack = new Stack<>();
            ArrayList<String> result = new ArrayList<>();
            Arrays.sort(plans, Comparator.comparing(arr -> arr[1]));
            LocalTime beforeStartTime = null;

            for (String[] plan : plans) {
                String subject = plan[0];
                LocalTime startTime = form(plan[1]);

                if (subjectStack.isEmpty()) {
                    subjectStack.add(subject);
                    useTimestack.add(Long.parseLong(plan[2]));
                    beforeStartTime = startTime;
                    continue;
                }

                long cal = cal(beforeStartTime, startTime);
                beforeStartTime = startTime;

                while (cal > -1) {
                    if (useTimestack.isEmpty()) {
                        break;
                    }

                    if (useTimestack.peek() - cal <= 0) {
                        cal -= useTimestack.pop();
                        result.add(subjectStack.pop());
                        continue;
                    }

                    useTimestack.add(useTimestack.pop() - cal);
                    break;
                }

                subjectStack.add(subject);
                useTimestack.add(Long.parseLong(plan[2]));

            }


            while (!subjectStack.isEmpty()) {
                result.add(subjectStack.pop());
            }

            return result.toArray(new String[0]);
        }

        private long cal (LocalTime start, LocalTime nextStart) {
            return Duration.between(start, nextStart).toMinutes();
        }


        private LocalTime form (String time) {
            String[] s = time.split(":");
            return LocalTime.of(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
    }
}
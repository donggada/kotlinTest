package com.example.kotlinTest.kakao2020InterShip;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test1_수식최대화 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution("100-200*300-500+20")
        ).isEqualTo(
                60420
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution("50*6-3*2")
        ).isEqualTo(
                300
        );
    }

    class Solution {
        static String[][] priority = {
                {"*", "+", "-"},
                {"*", "-", "+"},
                {"+", "*", "-"},
                {"+", "-", "*"},
                {"-", "+", "*"},
                {"-", "*", "-"}
        };
        static long answer;
        public long solution(String expression) {
            answer = 0;

            List<String> list = new ArrayList<>();
            int start = 0;
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                    list.add(expression.substring(start, i));
                    list.add(expression.charAt(i) + "");
                    start = i + 1;
                }
            }
            list.add(expression.substring(start));

            for (String[] pr :priority) {
                List<String> subList = new ArrayList<>(list);
                for (String p :pr) {
                    for (int i = 0; i <subList.size() ; i++) {
                        if (p.equals(subList.get(i))) {
                            subList.set(i-1, cal(subList.get(i-1), subList.get(i+1), subList.get(i)));
                            subList.remove(i);
                            subList.remove(i);
                            i--;
                        }
                    }
                }
                answer = Math.max(answer, Math.abs(Long.parseLong(subList.get(0))));
            }
            return answer;
        }

        private String cal (String left, String right, String op) {
            long leftNum = Long.parseLong(left);
            long rightNum = Long.parseLong(right);

            return switch (op) {
                case "*" -> String.valueOf(leftNum * rightNum);
                case "+" -> String.valueOf(leftNum + rightNum);
                case "-" -> String.valueOf(leftNum - rightNum);
                default -> "";
            };

        }
    }


}

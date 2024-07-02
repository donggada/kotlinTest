package com.example.kotlinTest.kakao2021InterShip;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Test3 {

    @Test
    void case1() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(8 , 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"})
        ).isEqualTo("OOOOXOOO");

    }


    @Test
    void case2() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(8 , 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"})
        ).isEqualTo("OOXOXOOO");
    }

    class Solution {
        public String solution(int n, int k, String[] cmd) {
            StringBuilder answer = new StringBuilder();
            boolean[] canceled = new boolean[n];

            Stack<Integer> cancelStack = new Stack<>();

            int index = k;

            for (String c : cmd) {
                String[] split = c.split(" ");
                String move = split[0];

                switch (move) {
                    case "D" -> {
                        int count = Integer.parseInt(split[1]);

                        while (count > 0) {
                            if (!canceled[index]) {
                                count--;
                            }
                            index++;
                        }
                    }
                    case "U" -> {
                        int count = Integer.parseInt(split[1]);

                        while (count > 0) {
                            if (!canceled[index]) {
                                count--;
                            }
                            index--;
                        }
                        continue;
                    }
                    case "Z" -> {
                        if (!cancelStack.isEmpty()) {
                            canceled[cancelStack.pop()] = false;
                        }
                        continue;
                    }

                    case "C" -> {
                        canceled[index] = true;
                        cancelStack.add(index);
                        if (index < n-1) {
                            index++;
                        } else {
                            index--;
                        }
                    }
                    default -> {index = index %n;}
                }
            }

            for (boolean b :canceled) {
                if (b) {
                    answer.append("X");
                    continue;
                }

                answer.append("O");
            }

            return answer.toString();
        }
    }
}

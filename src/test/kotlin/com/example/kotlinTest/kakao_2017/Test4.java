package com.example.kotlinTest.kakao_2017;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test4 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(2, new String[]{"N~F=0", "R~T>2"})
        ).isEqualTo(
                3648
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(2, new String[]{"M~C<2", "C~M>1"})
        ).isEqualTo(
                0
        );
    }

    class Solution {
        static int answer;
        static String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};
        static boolean[] visited;
        public int solution(int n, String[] data) {
            answer = 0;
            visited = new boolean[8];
            dfs(0, "" , data);
            return answer;
        }

        private void dfs(int depth, String result, String[] data) {
            if (depth == 8) {
                if (check(result, data)) {
                    answer++;
                }
                return;
            }

            for (int i = 0; i < 8 ; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, result + arr[i], data);
                    visited[i] = false;
                }
            }
        }

        private boolean check (String result, String[] data) {
            for (String s : data) {
                int first = result.indexOf(s.charAt(0));

                int second = result.indexOf(s.charAt(2));

                char condition = s.charAt(3);

                int num = Integer.parseInt(String.valueOf(s.charAt(4)));

                if (condition == '=') {
                    if (!(Math.abs(first - second) - 1 == num)) {
                        return false;
                    }
                }

                if (condition == '>') {
                    if (!(Math.abs(first - second) - 1 > num)) {
                        return false;
                    }
                }

                if (condition == '<') {
                    if (!(Math.abs(first - second) - 1 < num)) {
                        return false;
                    }
                }

            }
            return true;
        }


    }
}

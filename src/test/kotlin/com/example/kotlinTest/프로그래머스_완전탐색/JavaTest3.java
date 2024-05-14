package com.example.kotlinTest.프로그래머스_완전탐색;



import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest3 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution("17")
        ).isEqualTo(
            3
        );

        Assertions.assertThat(
            solution.solution("011")
        ).isEqualTo(
            2
        );


    }

    class Solution {
        static HashSet<Integer> set;
        static boolean[] visited = new boolean[7];
        public int solution(String numbers) {
            int answer = 0;
            set = new HashSet<>();
            dfs(numbers, "", 0);

            for (int n :set) {
                if(isPrime(n)){
                    answer++;
                }
            }

            return answer;
        }

        public static void dfs(String numbers, String s, int depth) {
            // numbers 의 끝까지 다 탐색했다면 종료
            if (depth > numbers.length()) {
                return;
            }

            for (int i = 0; i < numbers.length(); i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    System.out.println(s + numbers.charAt(i));
                    set.add(Integer.parseInt(s + numbers.charAt(i)));
                    dfs(numbers ,s + numbers.charAt(i), depth + 1);
                    visited[i] = false;
                }
            }
        }

        public static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            // 에라토스테네스 체
            for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }



}

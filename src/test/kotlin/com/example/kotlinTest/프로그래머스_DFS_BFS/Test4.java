package com.example.kotlinTest.프로그래머스_DFS_BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test4 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(
                "hit",	"cog",	new String[]{"hot", "dot", "dog", "lot", "log", "cog"})
            ).isEqualTo(4);

        Assertions.assertThat(
            solution.solution(
                "hit",	"cog",	new String[]{"hot", "dot", "dog", "lot", "log"})
        ).isEqualTo(0);


    }

    class Solution {
        static int answer;
        static String[] strings;
        static String targetWord;
        static HashSet<String> useWord;
        static LinkedList<String> queue;
        public int solution(String begin, String target, String[] words) {
            answer = 0;
            strings = words;
            targetWord = target;
            useWord = new HashSet<>();

            if (!Arrays.asList(words).stream().collect(Collectors.toSet()).contains(target)) {
                return 0;
            }
            queue = new LinkedList<>();
            queue.add(begin);
            bfs();

            return answer;
        }

        private static void bfs () {
            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size() ; i++) {
                    String word = queue.pop();

                    if (word.equals(targetWord)) {
                        return;
                    }

                    for (int j = 0; j < strings.length ; j++) {
                        String changeWord = strings[j];
                        if (!useWord.contains(changeWord) && check(changeWord, word)) {
                            useWord.add(changeWord);
                            queue.add(changeWord);
                        }
                    }
                }

                answer++;
            }


        }

        private static boolean check(String  word, String  target) {
            int wordSize = word.length();
            int count = 0;
            for (int i = 0; i <wordSize ; i++) {
                if (word.charAt(i) == target.charAt(i)) {
                    count++;
                }
            }
            return count == wordSize - 1;
        }
    }
}

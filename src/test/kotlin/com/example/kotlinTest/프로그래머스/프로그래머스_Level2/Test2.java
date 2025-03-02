package com.example.kotlinTest.프로그래머스.프로그래머스_Level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

public class Test2 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})
        ).isEqualTo(
                new int[]{3,3}
        );
    }

    @Test
    void case2() {
        assertThat(
                new Solution().solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})
        ).isEqualTo(
                new int[]{0,0}
        );
    }

    @Test
    void case3() {
        assertThat(
                new Solution().solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})
        ).isEqualTo(
                new int[]{1,3}
        );
    }

    class Solution {
        public int[] solution(int n, String[] words) {
            HashSet<String> set = new HashSet<>();
            set.add(words[0]);
            char lastWord = words[0].charAt(words[0].length()-1);

            for (int i = 1; i < words.length ; i++) {
                if (set.contains(words[i]) || lastWord != words[i].charAt(0)) {
                   return new int[]{(i % n) + 1 , (i/ n) + 1};
                }

                lastWord = words[i].charAt(words[i].length()-1);
                set.add(words[i]);
            }

            return new int[]{0,0};
        }
    }
}

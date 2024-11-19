package com.example.kotlinTest.아정당;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;


public class Test5 {

    @Test
    void case1() {
        Assertions.assertThat(new Solution().solution(2, "word", new String[]{})).isEqualTo(new String[]{} );
    }



    class Solution {
        public String[] solution(int k, String word, String[] titles) {
            String[] answer = {};
            String[] s = word.split("");
            word = "word";

            HashSet<String> set = new HashSet<>();

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < s.length ; i+=k) {
                set.add(word.substring(i, i+k));
            }


            for (int t = 0; t < titles.length; t++) {
                String title = titles[t];
                for (int i = 0; i < title.length(); i+=k) {
                    if (set.contains(title.substring(i, i+k))){
                     list.add(title);
                    }
                }
            }

            System.out.println(list);
            return answer;
        }
    }
}



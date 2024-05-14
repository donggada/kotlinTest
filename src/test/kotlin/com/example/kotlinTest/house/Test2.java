package com.example.kotlinTest.house;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Test2 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                    "ohouse", "oohoussse"
           )
        ).isEqualTo(true);


        Assertions.assertThat(
                solution.solution(
                        "bucketplace", "buckeetpladce"
                )
        ).isEqualTo(false);


    }

    class Solution {
        public boolean solution(String target, String typed) {
            LinkedList<Character> queue = new LinkedList<>();
            int index = 0;

            for (int i = 0; i < typed.length() ; i++) {
                char c = typed.charAt(i);
                if(target.charAt(index) == c) {
                    if (!queue.isEmpty()) {
                        queue.pop();
                    }
                    queue.add(c);
                    index++;
                    continue;
                }

                if (!queue.isEmpty()) {
                    if(queue.pop() == c) {
                        queue.add(c);
                        continue;
                    }
                }

                Math.max(1, 0);

                return false;
            }
            return true;
        }


    }
}

package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest6.Solution;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest7 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"fr*d*", "abc1**"})
        ).isEqualTo(2);

        Assertions.assertThat(
            solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"*rodo", "*rodo", "******"})
        ).isEqualTo(2);

        Assertions.assertThat(
            solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},new String[]{"fr*d*", "*rodo", "******", "******"})
        ).isEqualTo(3);
    }

    class Solution {

        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;


            return answer;
        }
    }
}

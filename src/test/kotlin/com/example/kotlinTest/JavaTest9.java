package com.example.kotlinTest;

import com.example.kotlinTest.JavaTest8.Solution;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest9 {
    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"})
        ).isEqualTo(2);
    }

    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            Map<String, Integer> giftMap = new HashMap<>();

            for (String friend:friends) {
                giftMap.put(friend, 0);
            }

            for (String giftRecord : gifts) {
                String[] info = giftRecord.split(" ");
                String sender = info[1];
                String receiver = info[0];

                giftMap.put(sender, giftMap.get(sender) - 1);
                giftMap.put(receiver, giftMap.get(receiver) + 1);
            }

            for (String friend : friends) {
                int giftCount = giftMap.get(friend);
                answer = Math.max(answer, giftCount);
            }

            return answer;
        }
    }

}

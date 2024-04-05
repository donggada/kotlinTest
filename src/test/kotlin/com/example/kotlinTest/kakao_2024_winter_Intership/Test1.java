package com.example.kotlinTest.kakao_2024_winter_Intership;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class Test1 {
    @Test
    void test () {
        Solution solution = new Solution();

        assertThat(
                solution.solution(
                        new String[]{"muzi", "ryan", "frodo", "neo"},
                        new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
                )
        ).isEqualTo(
            2
        );

        assertThat(
                solution.solution(
                        new String[]{"joy", "brad", "alessandro", "conan", "david"},
                        new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
                )
        ).isEqualTo(
                4
        );

        assertThat(
                solution.solution(
                        new String[]{"a", "b", "c"},
                        new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}
                )
        ).isEqualTo(
                0
        );




    }

    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
            HashMap<String, Integer> giftCountMap = new HashMap<>();

            for (String friend : friends) {
                map.put(friend, new HashMap<>());
            }

            for (String gift :gifts) {
                String[] giftInfo = gift.split(" ");
                String sender = giftInfo[0];
                String recipient = giftInfo[1];
                HashMap<String, Integer> giftMap = map.get(sender);

                giftCountMap.put(recipient, giftCountMap.getOrDefault(recipient, 0) - 1);
                giftCountMap.put(sender, giftCountMap.getOrDefault(sender, 0) + 1);

                giftMap.put(recipient, giftMap.getOrDefault(recipient, 0) + 1);
            }


            for (String key :map.keySet()) {
                int count = 0;
                HashMap<String, Integer> subMap = map.get(key);

                for (String friend :friends) {
                    if (key.equals(friend)) {
                        continue;
                    }

                    Integer subCount = subMap.getOrDefault(friend, 0);
                    Integer mapCount = map.get(friend).getOrDefault(key, 0);

                    if (subCount > mapCount) {
                        count++;
                        continue;
                    }

                    if (subCount.equals(mapCount)) {
                        if (giftCountMap.getOrDefault(friend, 0) < giftCountMap.getOrDefault(key, 0)){
                            count++;
                        }
                    }
                }

                answer= Math.max(answer, count);
            }


            return answer;
        }
    }
}

package com.example.kotlinTest.kakao2019;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})
        ).isEqualTo(
                new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}
        );
    }

    class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> map = new HashMap<>();

            ArrayList<String> list = new ArrayList<>();


            for (String re : record) {
                String[] records = re.split(" ");
                if (!records[0].equals("Leave")) {
                    map.put(records[1], records[2]);
                }

            }

            for (String re : record) {
                String[] records = re.split(" ");
                String action = records[0];
                String uid = records[1];
                if (action.equals("Leave")) {
                    list.add(map.get(uid) + "님이 나갔습니다.");
                    continue;
                }

                if (action.equals("Enter")) {
                    list.add(map.get(uid) + "님이 들어왔습니다.");
                }

            }

            String[] answer = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}

package com.example.kotlinTest.프로그래머스.프로그래머스_해시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest18 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})
        ).isEqualTo(
            new int[] {4, 1, 3, 0}
        );




    }

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer;
            ArrayList<Integer> result = new ArrayList<>();
            HashMap<String, HashMap<Integer,Integer>> map  = new HashMap<>();
            HashMap<String, Integer> genresCountMap  = new HashMap<>();

            for (int i = 0; i <genres.length ; i++) {
                String genre = genres[i];
                int play = plays[i];
                HashMap<Integer, Integer> playCountMap = map.getOrDefault(genre, new HashMap<>());
                playCountMap.put(i, play);
                map.put(genre, playCountMap);
                genresCountMap.put(genre, play + genresCountMap.getOrDefault(genre, 0));
            }

            List<Map.Entry<String, Integer>> keyList = new LinkedList<>(genresCountMap.entrySet());
            keyList.sort((o1, o2) -> o2.getValue() - o1.getValue());
            
            for (Entry<String, Integer> m : keyList) {
                String key = m.getKey();
                HashMap<Integer, Integer> integerIntegerHashMap = map.get(key);
                List<Map.Entry<Integer, Integer>> integerIntegerHashMapList = new LinkedList<>(integerIntegerHashMap.entrySet());
                integerIntegerHashMapList.sort((o1, o2) -> o2.getValue() - o1.getValue());
                if (integerIntegerHashMapList.size() >= 2) {
                    result.add(integerIntegerHashMapList.get(0).getKey());
                    result.add(integerIntegerHashMapList.get(1).getKey());
                } else {
                    result.add(integerIntegerHashMapList.get(0).getKey());
                }

            }

            answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
    }

}

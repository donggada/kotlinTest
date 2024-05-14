package com.example.kotlinTest.kakao2019;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 실패율 {
    Solution solution = new Solution();

    @Test
    void case1 () {
        Assertions.assertThat(
                solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})
        ).isEqualTo(
               new int[]{3,4,2,1,5}
        );
    }

    @Test
    void case2 () {
        Assertions.assertThat(
                solution.solution(4, new int[]{4,4,4,4,4})
        ).isEqualTo(
                new int[]{4,1,2,3}
        );
    }


    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Double, List<Integer>> failMap = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            double[] visited = new double[N];

            for (int stage : stages) {
                map.put(stage, map.getOrDefault(stage, 0) + 1);
                if (stage > N) {
                    stage = N;
                }
                for (int j = 0; j < stage; j++) {
                    visited[j]++;
                }
            }

            for (int i = 0; i < N ; i++) {
                double cal = 0.0;

                if (visited[i] == 0) {
                    List<Integer> list = failMap.getOrDefault(cal, new ArrayList<>());
                    list.add(i);
                    failMap.put(cal, list);
                    continue;
                }

                cal = map.getOrDefault(i + 1, 0) / visited[i];

                List<Integer> list = failMap.getOrDefault(cal, new ArrayList<>());
                list.add(i);
                failMap.put(cal, list);
            }


            List<Double> keySet = new ArrayList<>(failMap.keySet());

            keySet.sort(Collections.reverseOrder());


            for (double key : keySet) {
                List<Integer> list = failMap.get(key);
                Collections.sort(list);
                result.addAll(list);
            }

            for (int i = 0; i < result.size() ; i++) {
                answer[i] = result.get(i) + 1;
            }

            return answer;
        }
    }
}

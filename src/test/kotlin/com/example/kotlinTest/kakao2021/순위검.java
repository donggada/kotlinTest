package com.example.kotlinTest.kakao2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
public class 순위검 {

    @Test
    void test () {
        Solution solution = new Solution();

        Assertions.assertThat(
                solution.solution(
                        new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                        new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
                )
        ).isEqualTo(new int[]{1, 1, 1, 1, 2, 4});


    }



    class Solution {
        static HashMap<String, List<Integer>> map;
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            map = new HashMap<String, List<Integer>>();

            for (String in : info) {
                makeSentence(in.split(" "), "", 0);
            }

            for (String key : map.keySet()) {
                Collections.sort(map.get(key));
            }

            for (int i = 0; i < query.length ; i++) {
                query[i] = query[i].replaceAll(" and ", "");
                String[] q = query[i].split(" ");
                answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
            }

            return answer;
        }

        private static int binarySearch(String key, int score) {
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int start = 0;
            int end = list.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < score)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            return list.size() - start;
        }

        private static void makeSentence(String[] p, String str, int cnt) {
            if (cnt == 4) {
                if (!map.containsKey(str)) {
                    List<Integer> list = new ArrayList<Integer>();
                    map.put(str, list);
                }
                map.get(str).add(Integer.parseInt(p[4]));
                return;
            }
            makeSentence(p, str + "-", cnt + 1);
            makeSentence(p, str + p[cnt], cnt + 1);
        }
    }




}

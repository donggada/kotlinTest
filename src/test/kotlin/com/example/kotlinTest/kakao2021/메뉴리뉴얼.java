package com.example.kotlinTest.kakao2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 메뉴리뉴얼 {

    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                        new int[] {2,3,4}
                )
        ).isEqualTo(
                new String[]{"AC", "ACDE", "BCFG", "CDE"}
        );
    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                        new int[] {2,3,5}
                )
        ).isEqualTo(
                new String[]{"ACD", "AD", "ADE", "CD", "XYZ"}
        );
    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(
                        new String[]{"XYZ", "XWY", "WXA"},
                        new int[] {2,3,4}
                )
        ).isEqualTo(
                new String[]{"WX", "XY"}
        );
    }



    class Solution {
        static HashMap<String, Integer> map;
        public String[] solution(String[] orders, int[] course) {
            map = new HashMap<>();

            for (String order : orders) {
                String[] arr = order.split("");
                Arrays.sort(arr);
                boolean[] visited = new boolean[arr.length];
                backTracking(0, arr, visited, "");
            }

            ArrayList<String> result = new ArrayList<>();

            for (int len : course) {
                HashMap<Integer, List<String>> keyMap = new HashMap<>();
                int max = Integer.MIN_VALUE;

                for (String key : map.keySet()) {
                    if (key.length() == len) {
                        Integer val = map.get(key);
                        List<String> list = keyMap.getOrDefault(val, new ArrayList<>());
                        list.add(key);
                        keyMap.put(val, list);
                        max = Math.max(val, max);
                    }
                }

                if (max > 1) {
                    result.addAll(keyMap.get(max));
                }
            }

            Collections.sort(result);
            return result.toArray(new String[0]);
        }

        private void backTracking(int index, String[] arr, boolean[] visited, String key) {
            if (key.length() > 1) {
                map.put(key,map.getOrDefault(key, 0) + 1);
            }

            for (int i = index; i < arr.length ; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backTracking(i, arr, visited, key+arr[i]);
                    visited[i] = false;
                }
            }
        }
    }
}

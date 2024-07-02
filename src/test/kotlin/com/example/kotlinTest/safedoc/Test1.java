package com.example.kotlinTest.safedoc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test1 {


    @Test
    void case1 () {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(5, new String[]{"100 1 3", "500 4", "2000 5"}, new String[]{"300 3 5", "1500 1", "100 1 3", "50 1 2"}))
                .isEqualTo(new int[]{3, 3, 1, 0});
    }

    @Test
    void case2 () {
        Solution solution = new Solution();
        Assertions.assertThat(
                        solution.solution(5, new String[]{"38 2 3", "394 1 4"}, new String[]{"10 2 3", "300 1 2 3 4", "500 1"}))
                .isEqualTo(new int[]{1, 2, 0});
    }
    class Solution {
        static ArrayList<Integer> dateList;
        static ArrayList<List<String>> serviceList;
        public int[] solution(int n, String[] plans, String[] clients) {
            int[] answer = new int[clients.length];

            dateList = new ArrayList<>();
            serviceList = new ArrayList<>();

            for (int i = 0; i < plans.length ; i++) {
                String[] split = plans[i].split(" ");
                List<String> newList = new ArrayList<>();

                if (i != 0) {
                    newList.addAll(serviceList.get(i-1));
                }

                for (int j = 1; j <split.length ; j++) {
                    newList.add(split[j]);
                }

                dateList.add(Integer.parseInt(split[0]));
                serviceList.add(newList);
            }

            for (int i = 0; i < clients.length ; i++) {
                String[] split = clients[i].split(" ");
                boolean isNext = true;
                for (int j = 0; j < dateList.size() ; j++) {
                    if (!isNext) {
                        continue;
                    }
                    if(dateList.get(j) >= Integer.parseInt(split[0])) {
                        int size = 0;
                        for (int k = 1; k <split.length ; k++) {
                            if(serviceList.get(j).contains(split[k])) {
                                size++;
                            };
                        }

                        if(size == split.length - 1) {
                            answer[i] = j + 1;
                            isNext = false;
                        };
                    }


                }
            }

            return answer;
        }

    }

}

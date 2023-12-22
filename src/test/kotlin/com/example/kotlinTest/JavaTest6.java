package com.example.kotlinTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest6 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
        ).isEqualTo(new int[]{2, 1, 3, 4});

        Assertions.assertThat(
            solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")
        ).isEqualTo(new int[]{2, 1, 3, 4});

        Assertions.assertThat(
            solution.solution("{{20,111},{111}}")
        ).isEqualTo(new int[]{111, 20});

        Assertions.assertThat(
            solution.solution("{{123}}")
        ).isEqualTo(new int[]{123});

        Assertions.assertThat(
            solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")
        ).isEqualTo(new int[]{3 ,2, 4, 1});


    }
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            String substring = s.substring(1, s.length() - 2);
            String[] split = substring.split("},");
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

            for (int i = 0; i <split.length ; i++) {
                String[] sp = split[i].substring(1).split(",");
                ArrayList<Integer> subArr = new ArrayList<>();
                for (int j = 0; j <sp.length ; j++) {
                    subArr.add(Integer.parseInt(sp[j]));
                }
                arrayLists.add(subArr);
            }

            Collections.sort(arrayLists, Comparator.comparing(ArrayList::size));

            answer = new int[arrayLists.size()];

            List<Integer> numList = new ArrayList<>();


            for (int i = 0; i <arrayLists.size() ; i++) {
                ArrayList<Integer> arrayList = arrayLists.get(i);

                if (numList.isEmpty()) {
                    Integer num = arrayList.get(0);
                    numList.add(num);
                    answer[i] = num;
                    continue;
                }

                for (Integer num : arrayList) {
                    if (!numList.contains(num)) {
                        numList.add(num);
                        answer[i] = num;
                    }
                }
            }
            return answer;
        }
    }

}

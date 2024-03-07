package com.example.kotlinTest.Nexon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test2 {

    @Test
    public void test () {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);

//        list.add(1);
//        list.add(5);
//        list.add(3);
//        list.add(4);
//        list.add(2);

        Assertions.assertThat(
            Test2.countPairs(
                list, 2
            )
        ).isEqualTo(2);
    }


    public static int countPairs(List<Integer> projectCosts, int target) {
        Collections.sort(projectCosts);

        int count = 0;
        int left = 0;
        int right = 1;

        while (right < projectCosts.size()) {
            int difference = projectCosts.get(right) - projectCosts.get(left);

            if (difference == target) {
                count++;
            }

            if (difference >= target) {
                left++;
            } else {
                right++;
            }
        }

        return count;
    }


}

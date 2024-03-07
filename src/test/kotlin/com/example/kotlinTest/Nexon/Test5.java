package com.example.kotlinTest.Nexon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test5 {

    @Test
    void test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(17);
        arrayList.add(12);
        arrayList.add(10);
        arrayList.add(2);
        arrayList.add(7);
        arrayList.add(11);
        arrayList.add(20);
        arrayList.add(8);
        Assertions.assertThat(
            Test5.teamFormation(
                arrayList,3,4
            )
        ).isEqualTo(49);





    }


    public static long teamFormation(List<Integer> score, int team_size, int k) {
        Collections.sort(score, Collections.reverseOrder());

        long result = 0;
        int n = score.size();

        for (int i = 0; i < n; i += k) {
            int j = Math.min(i + team_size, n);
            List<Integer> team = score.subList(i, j);
            long teamScore = 0;
            for (int s : team) {
                teamScore += s;
            }
            result = Math.max(result, teamScore);
        }

        return result;
    }




}

package com.example.kotlinTest.Nexon;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void test() {

        Assertions.assertThat(
            Test1.entryTime("423692", "923857614")
        ).isEqualTo(8);

        Assertions.assertThat(
            Test1.entryTime("5111", "752961348")
        ).isEqualTo(1);

        Assertions.assertThat(
            Test1.entryTime("91566165", "639485712")
        ).isEqualTo(11);


    }
    public static int entryTime(String s, String keypad) {
        HashMap<Character, int[]> map = new HashMap();
        int count = 0;

        for (int i = 0; i < keypad.length() ; i++) {
            int x = i / 3;
            int y = i % 3;
            map.put(keypad.charAt(i), new int[]{x, y});
        }



        for (int i = 1; i < s.length()  ; i++) {
            int[] first = map.get(s.charAt(i - 1));
            int[] second = map.get(s.charAt(i));

            //대각선
            int diagonal = Math.min(Math.abs(first[0] - second[0]) , Math.abs(first[1] - second[1]));

            if (diagonal == 0) {
                count += Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
                continue;
            }

            if (diagonal == 2) {
                count+= diagonal;
                continue;
            }

            count += Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]) -1;
        }


        return count;
    }


}

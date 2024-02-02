package com.example.kotlinTest.netWork;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
            solution.solution(
                new String[]{"r 10", "a 23", "t 124", "k 9"},
                new String[]{"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"},
                new String[]{"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"})
        ).isEqualTo(1161);

        Assertions.assertThat(
            solution.solution(
                new String[]{"x 25","y 20", "Z 1000"},
                new String[]{"АААА хуху 15", "ТТТ уу 30", "BBBB xx 30"},
                new String[]{"BBBB 3", "TTT 2"})
        ).isEqualTo(-80);

    }

    class Solution {
        public int solution(String[] ings, String[] menu, String[] sell) {
            int answer = 0;
            Map<Character, Integer> ingMap = new HashMap<>();
            Map<String, Integer> menuCostMap = new HashMap<>();

            for (int i = 0; i <ings.length ; i++) {
                String[] ingInfo = ings[i].split(" ");
                ingMap.put(ingInfo[0].charAt(0) , Integer.parseInt(ingInfo[1]));
            }

            for (int i = 0; i <menu.length ; i++) {
                String[] menuInfo = menu[i].split(" ");
                int sumCost = 0;
                String menuIng = menuInfo[1];
                for (int j = 0; j <menuIng.length() ; j++) {
                    sumCost += ingMap.getOrDefault(menuIng.charAt(j),0);
                }

                menuCostMap.put(menuInfo[0] , Integer.parseInt(menuInfo[2]) - sumCost);
            }

            for (int i = 0; i <sell.length ; i++) {
                String[] sellInfo = sell[i].split(" ");

                Integer menuCost = menuCostMap.getOrDefault(sellInfo[0], 0);
                answer += menuCost * Integer.parseInt(sellInfo[1]);
            }

            return answer;
        }
    }
}

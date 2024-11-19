package com.example.kotlinTest.ebay;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test1 {

    @Test
    void case1() {
        Assertions.assertThat(new Solution().solution(
                5, new int[][]{{10, 60}, {15, 30}, {20, 80}, {30, 40}, {35,70}, {40,20}}
        )).isEqualTo(170);
    }

    @Test
    void case2() {
        Assertions.assertThat(new Solution().solution(
                5, new int[][]{{7, 35}, {5, 25}, {3, 15}, {1, 5}}
        )).isEqualTo(35);
    }

    @Test
    void case3() {
        Assertions.assertThat(new Solution().solution(
                4, new int[][]{{13, 39}, {16, 50}, {50, 17}, {61, 39}, {92, 22}}
        )).isEqualTo(128);
    }

    class Order {
        int date;
        int quantity;

        Order(int date, int quantity) {
            this.date = date;
            this.quantity = quantity;
        }
    }

    class Solution {
        public int solution(int n, int[][] orders) {
            List<Order> orderList = new ArrayList<>();
            for (int[] order : orders) {
                orderList.add(new Order(order[0], order[1]));
            }


            orderList.sort(Comparator.comparingInt(o -> o.date));

            int totalProduced = 0;
            int totalDelivered = 0;
            Stack<Integer> stack = new Stack<>();

            for (Order order : orderList) {
                int makeTotalCount = order.date * n;

                if (makeTotalCount < order.quantity) {
                    continue;
                }

                if (stack.isEmpty()) {
                    stack.add(order.quantity);
                    continue;
                }

                while (stack.peek() + order.quantity > makeTotalCount) {
                    int max = Math.max(stack.pop(), order.quantity);
                    stack.add(max);
                    makeTotalCount -= max;
                }

                stack.add(order.quantity);
            }

            while (!stack.isEmpty()) {
                totalDelivered += stack.pop();
            }

            return totalDelivered;
        }
    }
}

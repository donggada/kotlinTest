package com.example.kotlinTest.NexonTutorial;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Test2 {



    @Test
    void case1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        Test2.closestNumbers(list);
    }


    @Test
    void case2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(4);
        list.add(10);
        Test2.closestNumbers(list);
    }

    public static void closestNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);

        ArrayList<Integer> numList = new ArrayList<>(set);
        Collections.sort(numList);

        int gapMin = Integer.MAX_VALUE;

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < numList.size()-1 ; i++) {
            int gap = Math.abs(numList.get(i) - numList.get(i+1));
            if (gapMin > gap) {
                result.clear();
                result.add(new int[]{numList.get(i), numList.get(i+1)});
                gapMin = gap;
                continue;
            }

            if (gapMin == gap) {
                result.add(new int[]{numList.get(i), numList.get(i+1)});
            }
        }

        for (int[] r: result) {
            System.out.println(r[0] + " " + r[1]);
        }
    }


    public static class NearestNumbers {
        public static void nearestNumbers(List<Integer> numbers) {
            Collections.sort(numbers);

            int minGap = Integer.MAX_VALUE;
            List<String> result = new ArrayList<>();

            for (int i = 0; i < numbers.size() - 1; i++) {
                int gap = numbers.get(i+1) - numbers.get(i);

                if (gap < minGap) {
                    minGap = gap;
                    result.clear();
                    result.add(numbers.get(i) + " " + numbers.get(i+1));
                } else if (gap == minGap) {
                    result.add(numbers.get(i) + " " + numbers.get(i+1));
                }
            }

            result.stream().forEach(System.out::println);
        }
    }

}

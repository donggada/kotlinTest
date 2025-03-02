package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2024 {
    static HashMap<Integer, List<Integer>> map;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        while (true) {
            String s = br.readLine();

            if(s.equals("0 0")) {
                break;
            }

            String[] sp = s.split(" ");
            int key = Integer.parseInt(sp[0]);
            int value = Integer.parseInt(sp[1]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());

            list.add(value);
            map.put(key, list);
        }
        cal(0, m,0);
        System.out.println(minCount == Integer.MAX_VALUE ? 0 : minCount);

    }
    private static void cal (int key, int m, int count) {
        if (m < -1) {
            return;
        }

        if (!map.containsKey(key)) {
            return;
        }

        List<Integer> list = map.get(key);

        if (list.contains(m)) {
            minCount = Math.min(minCount, count + 1);
            return;
        }

        for (int n : list) {
            if (m >= n) {
                cal(n, m - n, count+1);
            }
        }
    }
}

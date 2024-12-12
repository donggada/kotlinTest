package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");

            int key = Integer.parseInt(s[0]);
            Integer value = map.getOrDefault(key, 0);
            int newValue = Integer.parseInt(s[1]);

            if (value < newValue) {
                map.put(key, newValue);
            }
        }

        System.out.println(map.values().stream().mapToInt(Integer::intValue).sum());


    }
}

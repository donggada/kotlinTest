package com.example.kotlinTest.백준.백준_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;

        for (int i = 0; i < 9 ; i++) {
            int val = Integer.parseInt(br.readLine());
            max = Math.max(val, max);
            map.put(val, i);
        }

        System.out.println(max);
        System.out.println(map.get(max) + 1);
    }
}

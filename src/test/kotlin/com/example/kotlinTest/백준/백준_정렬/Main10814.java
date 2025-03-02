package com.example.kotlinTest.백준.백준_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            int key = Integer.parseInt(s[0]);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s[1]);
            map.put(key, list);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int key : list) {
            map.get(key).forEach(
                    v -> {
                        System.out.println(key + " " + v);
                    }
            );
        }


    }
}

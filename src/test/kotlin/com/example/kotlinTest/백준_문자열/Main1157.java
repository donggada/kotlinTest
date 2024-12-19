package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String upperCaseString = s.toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <upperCaseString.length() ; i++) {
            char key = upperCaseString.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }


        int maxValue = map.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        Set<Character> keySet = map.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());


        if (keySet.size() == 1) {
            keySet.forEach(System.out::println);
            return;
        }

        System.out.println("?");
    }
}

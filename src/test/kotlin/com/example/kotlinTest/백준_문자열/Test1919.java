package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test1919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < first.length() ; i++) {
            char key = first.charAt(i);
            Integer count = map.getOrDefault(key, 0);

            map.put(key, count + 1);
        }

        for (int i = 0; i < second.length() ; i++) {
            char key = second.charAt(i);

            if (map.containsKey(key)) {
                Integer count = map.get(key);
                map.put(key, count -1);
                continue;
            }

            result++;
        }

        for (Character key : map.keySet()) {
            result += Math.abs(map.get(key));
        }

        System.out.println(result);
    }
}

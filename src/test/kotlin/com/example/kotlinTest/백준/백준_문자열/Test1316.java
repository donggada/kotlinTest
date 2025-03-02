package com.example.kotlinTest.백준.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N ; i++) {
            Map<Character, Integer> map = new HashMap<>();
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {

                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    if (map.get(c) + 1 != j) {
                        count++;
                        break;
                    }
                }

                map.put(c, j);
            }
        }

        System.out.println(N - count);
    }
}

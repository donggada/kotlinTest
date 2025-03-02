package com.example.kotlinTest.백준.백준_수학적문제해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class Test9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());


        for (int i = 0; i < caseCount ; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                String[] split = br.readLine().split(" ");
                map.put(split[1], map.getOrDefault(split[1], 0) + 1);
            }
            int result = 1;

            for (Integer val : map.values()) {
                result *= (val + 1);
            }

            System.out.println(result -1);
        }
    }
}

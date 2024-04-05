package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    static Map<Integer, Integer> dpMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dpMap = new HashMap<>();
        dpMap.put(1, 0);
        dpMap.put(2, 1);

        int dp = dp(n);

        System.out.println(dp);

    }

    private static int dp(int n) {
        if (dpMap.containsKey(n)) {
            return dpMap.get(n);
        }

        if (n % 6 == 0) {
            int result = Math.min(Math.min(dp(n / 3) + 1, dp(n - 1) + 1), dp(n / 2) + 1);
            dpMap.put(n, result);
            return result;
        }

        if (n % 3 == 0) {
            int result = Math.min(dp(n / 3) + 1, dp(n - 1) + 1);
            dpMap.put(n, result);
            return result;

        }

        if (n % 2 == 0) {
            int result = Math.min(dp(n / 2) + 1, dp(n - 1) + 1);
            dpMap.put(n, result);
            return result;
        }

        return dp(n - 1) + 1;
    }
}

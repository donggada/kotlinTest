package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1003 {


    static int zeroCount;
    static int oneCount;
    static Map<Integer, int[]> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            zeroCount = 0;
            oneCount = 0;
            int N = Integer.parseInt(br.readLine());
            dp = new HashMap<>();
//            topDowm(N);
            bottomUp(N);

            System.out.println(zeroCount + " " + oneCount);
        }
    }

    private static void bottomUp(int n) {
        dp.put(0, new int[]{1,0});
        dp.put(1, new int[]{0,1});
        for (int i = 2; i <= n ; i++) {
            int[] arr1 = dp.get(i - 1);
            int[] arr2 = dp.get(i - 2);
            dp.put(i, new int[]{arr1[0]+ arr2[0], arr1[1] + arr2[1]});
        }

        int[] arr = dp.get(n);
        zeroCount += arr[0];
        oneCount += arr[1];
    }

    private static void topDowm(int n) {
        if (n == 0) {
            zeroCount++;
            return;
        }

        if (n == 1) {
            oneCount++;
            return;
        }

        if (dp.containsKey(n)) {
            int[] arr = dp.get(n);
            zeroCount += arr[0];
            oneCount += arr[1];
            return;
        }

        topDowm(n-1);
        topDowm(n-2);

        dp.put(n, new int[]{zeroCount, oneCount});
    }
}

package com.example.kotlinTest.백준_DP;

import java.io.*;

public class Test1463 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n = Integer.parseInt(br.readLine());

//        arr = new int[n + 2];
//
//        arr[2] = 1;
//        arr[3] = 1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(bottomUp(n) + "\n");

        bw.flush();
        bw.close();

    }

    private static int bottomUp(int n) {
        int[] arr = new int[1000001];
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < arr.length ; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                arr[i] = Math.min(Math.min(arr[i/2], arr[i/3]), arr[i-1]) + 1;
                continue;
            }

            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i/3] , arr[i-1]) + 1;
                continue;
            }

            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i/2] , arr[i-1]) + 1;
                continue;
            }

            arr[i] = arr[i-1] + 1;
        }

        return arr[n];
    }

//    private static int dp(int n) {
//        if (n == 2) {
//            return 1;
//        }
//
//        if (n == 3) {
//            return 1;
//        }
//
//        if (arr[n] != 0) {
//            return arr[n];
//        }
//
//        if (n % 3 == 0 && n % 2 == 0) {
//            return Math.min(dp(n-1), Math.min(dp(n/3), dp(n/2))) + 1;
//        }
//
//        if (n % 3 == 0) {
//            return Math.min(dp(n-1), dp(n/3)) + 1;
//        }
//
//        if (n % 2 == 0) {
//            return Math.min(dp(n-1), dp(n/2)) + 1;
//        }
//
//        return dp(n-1) + 1;
//    }

}

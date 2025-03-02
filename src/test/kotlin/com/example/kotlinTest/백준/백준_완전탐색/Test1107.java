package com.example.kotlinTest.백준.백준_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Test1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));




        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> errorButton = new HashSet<>();

        if (M != 0) {
            String[] split = br.readLine().split(" ");
            for (String s : split) {
                errorButton.add(Integer.parseInt(s));
            }
        }


        System.out.println(cal(N, errorButton));
    }

    private static int cal (int N, HashSet<Integer> errorButton) {
        if (N == 100) {
            return 0;
        }

        // 성능 좀 빠르게 연산
        //999999 값 말고 같은자리수에  최대값 으로 변경

        int minCount = Math.abs(N - 100);

        for (int num = 999999; num > -1 ; num--) {
            String[] split = String.valueOf(num).split("");
            boolean isMake = true;
            for (String s : split) {
                if (errorButton.contains(Integer.parseInt(s))) {
                    isMake = false;
                    break;
                }
            }

            if (isMake) {
                minCount = Math.min(String.valueOf(num).length() + Math.abs(N - num), minCount);
            }
        }


        return minCount;
    }
}

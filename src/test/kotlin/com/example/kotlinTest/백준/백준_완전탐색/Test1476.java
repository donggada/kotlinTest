package com.example.kotlinTest.백준.백준_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int E = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int M = Integer.parseInt(split[2]);

        System.out.println(cal(E, S, M));
    }
    private static boolean check(int n, int E, int S, int M) {
        int e = E;
        int s = S;
        int m = M;

        if (E == 15) {
            e = 0;
        }

        if (S == 28) {
            s = 0;
        }

        if (M == 19) {
            m = 0;
        }

        return n % 15 == e && n % 28 == s && n % 19 == m;

    }

    private static int cal(int E, int S, int M) {
        int num = 1;

        while (!check(num, E ,S ,M)) {
            num++;
        }

        return num;
    }

}

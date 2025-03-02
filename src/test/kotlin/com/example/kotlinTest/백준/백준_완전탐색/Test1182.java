package com.example.kotlinTest.백준.백준_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1182 {

    static int count;
    static int N;
    static int S;
    static int[] numList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        count = 0;
        numList = new int[N];

        String[] stringNumList = br.readLine().split(" ");

        for (int i = 0; i < stringNumList.length ; i++) {
            numList[i] = Integer.parseInt(stringNumList[i]);
        }

        dfs(0,0);
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(depth + 1, sum + numList[depth]);
        dfs(depth + 1, sum);
    }

}

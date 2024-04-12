package com.example.kotlinTest.백준_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test14888 {

    static int[] arr;
    static int N;
    static int max;
    static int min;
    static int[] numList;
    static int[] calculation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        arr = new int[N];
        calculation = new int[4];

        String[] numList = br.readLine().split(" ");

        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(numList[i]);
        }

        String[] calculationList = br.readLine().split(" ");

        for (int i = 0; i < 4 ; i++) {
            calculation[i] = Integer.parseInt(calculationList[i]);
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);


    }

    private static void dfs(int index, int sum) {
        if (index == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calculation[i] > 0) {

                calculation[i]--;

                switch (i) {
                    case 0 : dfs(index + 1, sum + arr[index]); break;
                    case 1 : dfs(index + 1, sum - arr[index]); break;
                    case 2 : dfs(index + 1, sum * arr[index]); break;
                    case 3 : dfs(index + 1, sum / arr[index]); break;
                }

                calculation[i]++;
            }


        }
    }
}

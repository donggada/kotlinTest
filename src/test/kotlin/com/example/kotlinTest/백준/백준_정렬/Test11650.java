package com.example.kotlinTest.백준.백준_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];


        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, (n1 ,n2) -> n1[0] != n2[0] ? n1[0]-n2[0] : n1[1]-n2[1]);


        for (int i = 0; i < N ; i++) {
            System.out.println(arr[i][0] +" "+ arr[i][1]);
        }
    }
}

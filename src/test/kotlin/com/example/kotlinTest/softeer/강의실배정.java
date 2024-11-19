package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());


        int[][] arr = new int[N][2];


        for (int i = 0; i < N ; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(s[0]);
            arr[i][1] = Integer.valueOf(s[1]);
        }

        Arrays.sort(arr, (arr1, arr2) -> arr1[1] == arr2[1] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);


        int count = 0;
        long endTime = 0;

        for (int[] a : arr) {
            if (endTime <= a[0]) {
                endTime = a[1];
                count++;
            }
        }



        System.out.println(count);
    }
}
//4
//1 3
//2 4
//3 5
//6 10

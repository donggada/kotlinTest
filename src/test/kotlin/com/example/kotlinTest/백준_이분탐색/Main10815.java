package com.example.kotlinTest.백준_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main10815 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        arr = new int[n];
        HashSet<String> set = new HashSet<>();

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.valueOf(s[i]);
            set.add(s[i]);
        }

        Integer m = Integer.valueOf(br.readLine());
        String[] sp = br.readLine().split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < m ; i++) {
            if (set.contains(sp[i])) {
                result.append("1").append(" ");
                continue;
            }
            result.append("0").append(" ");
        }

        System.out.println(result);
    }


    private static boolean binarySearch(int val) {
        return Arrays.binarySearch(arr, val) > -1;
    }

    private static boolean customBinarySearch(int val) {
        int mid = arr.length / 2;
        int right = arr.length-1;

        for (int left = 0; left < mid + 1 ; left++) {
            if (arr[left] == val) {
                return true;
            }

            if (arr[right] == val) {
                return true;
            }


            right--;
        }
        return false;
    }
}

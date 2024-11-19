package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 자동차테스트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int q = Integer.valueOf(s[1]);
        int[] arr = new int[n];

        String[] sp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(sp[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < q ; i++) {
            int index = Arrays.binarySearch(arr, Integer.valueOf(br.readLine()));

            if (index < -1) {
                System.out.println(0);
                continue;
            }

            System.out.println(index * (n - 1  - index));
        }
    }

    // todo 이중탐색 직접구현
    private int binarySearch(int[] arr, int val) {
        return 0;
    }
}

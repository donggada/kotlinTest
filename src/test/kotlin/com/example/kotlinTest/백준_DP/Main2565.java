package com.example.kotlinTest.백준_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2565 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(s[0]);
            arr[i][1] = Integer.valueOf(s[1]);
        }
//        dp();
        lts();
    }

    private static void dp() {
        int[] dp = new int[n];

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(n - dp[n - 1]);
    }

    private static void lts() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int[] a : arr) {
            int num = a[1];
            //리스트 마지막에 넣어야 되는 경우 => 뒤에 넣기
            if (num > list.get(list.size() - 1)) {
                list.add(num);
                continue;
            }

            //넣을 위치 찾는다
            int left = 0;
            int right = list.size() - 1;
            int mid;

            while (left < right) {
                mid = (left + right) / 2;
                if (list.get(mid) < num) {
                    left = mid + 1;
                    continue;
                }

                right = mid;
            }

            list.set(right, num);
        }

        System.out.println(n- list.size() - 1);
    }
}

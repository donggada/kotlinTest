package com.example.kotlinTest.백준_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main12015 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        String[] s = br.readLine().split(" ");

        arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }

        lts();
    }

    private static void lts() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int num : arr) {
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
                    list.set(right, num);
                    continue;
                }

                right = mid;
            }

            list.set(right, num);
        }

        System.out.println(list.size() - 1);
    }
}

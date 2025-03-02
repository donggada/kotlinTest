package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] arr = n.split("");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length ; i++) {
            list.add(Integer.valueOf(arr[i]));
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        list.sort(Collections.reverseOrder());

        // 핵심 -> 숫자들을 전부 더했을 때, 값이 3의 배수인지 확인 && 0 여부 확인
        if (sum % 3 != 0 || list.get(list.size()-1) != 0) {
            System.out.println(-1);
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (int num : list) {
            sb.append(num);
        }

        System.out.println(sb);
    }
}

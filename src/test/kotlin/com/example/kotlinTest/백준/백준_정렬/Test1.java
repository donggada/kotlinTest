package com.example.kotlinTest.백준.백준_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
//        int[] arr = new int[size];
//
//        for (int i = 0; i < size ; i++) {
//            int n = scanner.nextInt();
//            int index = n - 1;
//            arr[index] = n;
//        }
//
//        for (int i : arr) {
//            if (i != 0) {
//                System.out.println(i);
//            }
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}

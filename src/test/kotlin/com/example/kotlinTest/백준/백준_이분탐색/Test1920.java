package com.example.kotlinTest.백준.백준_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Test1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String[] A = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <A.length ; i++) {
            set.add(A[i]);
        }

        br.readLine();

        String[] M = br.readLine().split(" ");

        for (int i = 0; i < M.length; i++) {
            if (set.contains(M[i])) {
                System.out.println("1");
                continue;
            }

            System.out.println("0");
        }

    }
}

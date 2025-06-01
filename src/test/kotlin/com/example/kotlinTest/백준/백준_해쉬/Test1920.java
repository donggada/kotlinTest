package com.example.kotlinTest.백준.백준_해쉬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

public class Test1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String[] A = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>();

        Collections.addAll(set, A);

        br.readLine();

        String[] M = br.readLine().split(" ");

        for (String s : M) {
            if (set.contains(s)) {
                System.out.println("");
                continue;
            }

            System.out.println("0");
        }

    }
}

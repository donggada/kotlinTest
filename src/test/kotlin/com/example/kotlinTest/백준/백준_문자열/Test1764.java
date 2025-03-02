package com.example.kotlinTest.백준.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Test1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N ; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M ; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }


        Collections.sort(list);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }
}

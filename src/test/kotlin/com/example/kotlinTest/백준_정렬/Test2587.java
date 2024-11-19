package com.example.kotlinTest.백준_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Test2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5 ; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
        }

        Collections.sort(list);

        System.out.println((int) list.stream().mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println(list.get(list.size() / 2));
    }
}

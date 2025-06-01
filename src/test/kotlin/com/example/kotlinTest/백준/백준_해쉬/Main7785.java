package com.example.kotlinTest.백준.백준_해쉬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            String name = s[0];

            if (s[1].equals("enter")) {
                set.add(name);
                continue;
            }

            set.remove(name);
        }

        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());

        for (String name : list) {
            System.out.println(name);
        }
    }

}

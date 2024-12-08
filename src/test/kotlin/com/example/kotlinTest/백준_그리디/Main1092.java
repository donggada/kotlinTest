package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        List<Integer> crane = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            crane.add(Integer.valueOf(s[i]));
        }

        Integer m = Integer.valueOf(br.readLine());
        String[] sp = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            box.add(Integer.valueOf(sp[i]));
        }

        Collections.sort(crane, Comparator.reverseOrder());
        Collections.sort(box, Comparator.reverseOrder());

        if(crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!box.isEmpty()) {
            int index = 0;
            for(int i = 0; i < crane.size();) {
                if(index == box.size()) {
                    break;
                }

                if(crane.get(i) >= box.get(index)) {
                    box.remove(index);
                    i++;
                    continue;
                }

                index++;
            }
            time++;
        }

        System.out.println(time);
    }
}

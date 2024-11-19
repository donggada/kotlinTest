package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 금고털이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int W = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        int total = 0;

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] sp = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(sp[0]), Integer.parseInt(sp[1])});
        }

        Collections.sort(list,(o1,o2) -> o2[1] - o1[1]);

        for(int[] item : list){
            if(W <= item[0]){
                total += W * item[1];
                break;
            }

            total += item[0] * item[1];
            W -= item[0];
        }

        System.out.println(total);
    }
}


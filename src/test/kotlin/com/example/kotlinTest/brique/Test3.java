package com.example.kotlinTest.brique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test3 {
//    Input: 7 3
//    result: <3, 6, 2, 7, 5, 1, 4>
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            numList.add(i+1);
        }

        int removeIndex = 0;

        while (!numList.isEmpty()) {
            removeIndex = (removeIndex + m - 1) % numList.size();
            result.add(numList.remove(removeIndex));
        }

        System.out.println(result);
    }
}

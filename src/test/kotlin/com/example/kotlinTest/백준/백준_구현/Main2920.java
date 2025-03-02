package com.example.kotlinTest.백준.백준_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");

        int firstValue = Integer.parseInt(sp[0]);
        for (int i = 0; i < sp.length - 1; i++) {
            int val1 = Integer.parseInt(sp[i]);
            int val2 = Integer.parseInt(sp[i+1]);

            if (Math.abs(val1 - val2) != 1) {
                System.out.println("mixed");
                return;
            }

        }

        if (firstValue == 1) {
            System.out.println("ascending");
            return;
        }

        System.out.println("descending");
    }
}

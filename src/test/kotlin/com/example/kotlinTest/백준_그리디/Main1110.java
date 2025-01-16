package com.example.kotlinTest.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int init = Integer.parseInt(br.readLine());
        int varInit = init;
        int varNum = 0;
        int count = 0;

        if (init == 0) {
            System.out.println(1);
            return;
        }

        while (true) {
            if (init == varNum) {
                System.out.println(count);
                break;
            }

            int first = varInit / 10;
            int second = varInit % 10;

            varNum = (second * 10) + ((first + second) % 10);
            varInit = varNum;

            count++;
        }
    }
}

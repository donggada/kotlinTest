package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 전광판 {
    public static void main(String[] args) throws IOException {

        boolean[][] board  ={
                /*0*/    {true, true, true, true, true, true, false},
                /*1*/    {false, false, true, true, false, false, false},
                /*2*/    {false, true, true, false, true, true, true},
                /*3*/    {false, true, true, true, true, false, false},
                /*4*/    {true, false, true, true, false, false, true},
                /*5*/    {true, true, false, true, true, false, true},
                /*6*/    {true, false, false, true, true, true, true},
                /*7*/    {true, true, true, true, false, false, false},
                /*8*/    {true, true, true, true, true, true, true},
                /*9*/    {true, true, true, true, true, false, true},
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T ; i++) {
            int count  = 0;
            String[] sp = br.readLine().split(" ");
            String s1 = sp[0];
            String s2 = sp[1];

            while (5 > s1.length()) {
                s1 = "0" + s1;
            }

            while (5 > s2.length()) {
                s2 = "0" + s2;
            }
            boolean isS1FirstZero = true;
            boolean isS2FirstZero = true;
            for (int j = 0; j < 5 ; j++) {
                int s1Index = Integer.parseInt(String.valueOf(s1.charAt(j)));
                int s2Index = Integer.parseInt(String.valueOf(s2.charAt(j)));

                if (s1Index != 0) {
                    isS1FirstZero = false;
                }

                if (s2Index != 0) {
                    isS2FirstZero = false;
                }

                if (s1Index != s2Index) {
                     if (isS1FirstZero && s1Index == 0) {
                         count += cal(board[s2Index]);
                     } else if (isS2FirstZero && s2Index == 0) {
                         count += cal(board[s1Index]);
                     } else {
                         count += cal(board[s1Index], board[s2Index]);
                     }
                }


            }

            System.out.println(count);
        }
    }
    private static int cal (boolean[] b1, boolean[] b2) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (b1[i] != b2[i]) {
                count++;
            }
        }
        return count;
    }

    private static int cal (boolean[] b1) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (b1[i]) {
                count++;
            }
        }
        return count;
    }

}

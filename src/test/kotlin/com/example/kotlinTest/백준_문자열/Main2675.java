package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T ; i++) {
            String[] br = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(br[0]);
            String[] s = br[1].split("");
            StringBuffer sb = new StringBuffer();

            for (String string : s) {
                sb.append(String.valueOf(string).repeat(Math.max(0, n)));
            }

            System.out.println(sb);
        }
    }
}

package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T ; i++) {
            String[] br = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(br[0]);
            String[] s = br[1].split("");
            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < s.length; j++) {
                for (int k = 0; k < n ; k++) {
                    sb.append(s[j]);
                }
            }

            System.out.println(sb);
        }
    }
}

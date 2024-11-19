package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        long K = Integer.parseInt(s[0]);
        long P = Integer.parseInt(s[1]);
        long N = Integer.parseInt(s[2]);

        long answer = K;


        for(int i= 0; i < N; i++) {
            answer *= P;
            answer %= 1000000007;
        }

        System.out.println(answer);

    }
}

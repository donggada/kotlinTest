package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 슈퍼바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int K = Integer.valueOf(s[0]);
        int P = Integer.valueOf(s[1]);
        long N = Long.valueOf(s[2]);

        System.out.println(K * self(P, N * 10) % 1000000007);
    }
    private static long self(long p, long n)  {
        if (n == 1) {
            return p;
        }

        long half = self(p, n / 2);

        if (n % 2 == 0) {
            return (half * half) % 1000000007;
        }

        if (n % 2 == 1) {
            return ((half * half) % 1000000007) * p % 1000000007;
        }

        return p;
    }
}

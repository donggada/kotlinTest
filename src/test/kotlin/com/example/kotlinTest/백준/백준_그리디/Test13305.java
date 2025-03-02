package com.example.kotlinTest.백준.백준_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] r = br.readLine().split(" ");
        String[] c = br.readLine().split(" ");
        long[] road = new long[r.length];
        long[] cost = new long[c.length];

        for (int i = 0; i < r.length; i++) {
            road[i] = Integer.parseInt(r[i]);
        }

        for (int i = 0; i < c.length; i++) {
            cost[i] =  Integer.parseInt(c[i]);
        }

        long price = cost[0];
        long sum = 0;

        for (int i = 0; i < road.length ; i++) {
            if (price > cost[i]) {
                price = cost[i];
            }

            sum += (price * road[i]);
        }

        System.out.println(sum);
    }


}

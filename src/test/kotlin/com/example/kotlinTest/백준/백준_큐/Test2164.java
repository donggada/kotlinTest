package com.example.kotlinTest.백준.백준_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n =Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }
        int result = 0;

        while (!queue.isEmpty()) {
            result = queue.pop();

            if (queue.isEmpty()) {
                break;
            }

            queue.add(queue.pop());
        }

        System.out.println(result);
    }
}

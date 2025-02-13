package com.example.kotlinTest.brique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Test1 {
//    Input: 6 9 5 7 4
//    result: 0 0 2 2 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[sp.length];

        for (int i = 0; i < sp.length ; i++) {
            int height = Integer.parseInt(sp[i]);

            while (!stack.isEmpty() && Integer.parseInt(sp[stack.peek()]) < height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1;
            }

            stack.add(i);
        }

        System.out.println(Arrays.toString(result));
    }
}

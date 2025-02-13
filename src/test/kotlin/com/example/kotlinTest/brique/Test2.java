package com.example.kotlinTest.brique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Test2 {

//    Input: )()())
//    result: 4

//    Input: (()
//    result: 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
                continue;
            }

            stack.pop();

            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            maxLen = Math.max(maxLen, i - stack.peek());
        }

        System.out.println(maxLen);
    }
}

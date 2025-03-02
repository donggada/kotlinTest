package com.example.kotlinTest.백준.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();
        int length = bomb.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            stack.add(s.charAt(i));

            if (stack.size() >= length) {
                int count = 0;
                for (int j = 0; j < length ; j++) {
                    if (stack.get(stack.size() - length + j) == bomb.charAt(j)) {
                        count++;
                    }

                    if (count == length) {
                        for (int k = 0; k < length ; k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        System.out.println(stack.isEmpty() ? "FRULA" : stack.stream().map(String::valueOf).collect(Collectors.joining()));

    }
}

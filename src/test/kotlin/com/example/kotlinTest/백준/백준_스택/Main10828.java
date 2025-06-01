package com.example.kotlinTest.백준.백준_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            String command = s[0];

            if (command.equals("push")) {
                stack.add(Integer.parseInt(s[1]));
                continue;
            }

            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(stack.peek()).append("\n");
                continue;
            }

            if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
                continue;
            }

            if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1").append("\n");
                    continue;
                }
                sb.append("0").append("\n");
                continue;
            }

            if (stack.isEmpty()) {
                sb.append("-1").append("\n");
                continue;
            }
            sb.append(stack.pop()).append("\n");

        }

        System.out.println(sb);
    }

}

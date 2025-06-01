package com.example.kotlinTest.백준.백준_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n ; i++) {
            String[] s = br.readLine().split(" ");
            String command = s[0];

            if (command.equals("push")) {
                queue.add(Integer.parseInt(s[1]));
                continue;
            }

            if (command.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.peek()).append("\n");
                continue;
            }

            if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(queue.get(queue.size()-1)).append("\n");
                continue;
            }

            if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
                continue;
            }

            if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                    continue;
                }
                sb.append("0").append("\n");
                continue;
            }

            if (queue.isEmpty()) {
                sb.append("-1").append("\n");
                continue;
            }
            sb.append(queue.pop()).append("\n");

        }

        System.out.println(sb);
    }
}

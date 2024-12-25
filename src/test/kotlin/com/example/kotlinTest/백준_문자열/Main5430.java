package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t ; i++) {
            boolean isError = false;
            boolean isReverse = false;
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String element = br.readLine();
            String[] substring = element.substring(1, element.length() - 1).split(",");

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n ; j++) {
                list.add(Integer.parseInt(substring[j]));
            }

            for (int j = 0; j <command.length(); j++) {
                if (command.charAt(j) == 'D') {
                    if (list.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    list.remove(0);
                }

                if (command.charAt(j) == 'R') {
                    if (isReverse) {
                        Collections.sort(list);
                        isReverse = false;
                        continue;
                    }
                    list.sort(Collections.reverseOrder());
                    isReverse = true;
                }
            }

            if (!isError) {
                System.out.println(list);
            }
        }
    }
}

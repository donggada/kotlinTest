package com.example.kotlinTest.line_plus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    static List<String> vlidsList;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        vlidsList = new ArrayList<>();
        backTracking(s, 0, new ArrayList<>());
        Collections.sort(vlidsList);

        System.out.println(vlidsList.size());
        vlidsList.forEach(System.out::println);
    }
    private static void backTracking(String s, int index, List<String> list) {
        if (list.size() == 4) {
            if (index == s.length()) {
                vlidsList.add(String.join(".", list));
            }
            return;
        }

        for (int i = 1; i <= 3 ; i++) {
            if (index + i > s.length()) {
                break;
            }

            String numString = s.substring(index, index + i);

            if (check(numString)) {
                list.add(numString);
                backTracking(s, index + i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean check(String numString) {
        if(numString.length() > 1 && numString.startsWith("0")) {
            return false;
        }
        int n = Integer.parseInt(numString);
        return n >= 0 && n <= 255;
    }
}

package com.example.kotlinTest.line_plus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    static char[] elementArray;
    static char[] delimiterArray;
    static List<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String delimiter = sc.nextLine();
        String element = sc.nextLine();

        elementArray = element.toCharArray();
        delimiterArray = delimiter.toCharArray();
        result = new ArrayList<>();

        if (element.isEmpty()) {
            System.out.println(0);
            System.out.println(element);
            return;
        }

        combination(0, new StringBuilder());

        System.out.println(result.size());
        result.forEach((System.out::println));
    }

    private static void combination(int index, StringBuilder sb) {
        if (index == elementArray.length) {
            result.add(sb.toString());
            return;
        }

        int beforeLen = sb.length();
        sb.append(elementArray[index]);

        if (index == elementArray.length - 1) {
            combination(index+1, sb);
        } else {
            for (char de : delimiterArray) {
                int len = sb.length();
                sb.append(de);
                combination(index+1, sb);
                sb.setLength(len);
            }

        }
        sb.setLength(beforeLen);
    }
}

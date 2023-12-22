package com.example.kotlinTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class JavaTest5 {
    public static int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
    public static int[] dsc = {8, 7, 6, 5, 4, 3, 2, 1};
    public static boolean cal(int[] arr1, int[] arr2) {
        for(int i = 0; i < 8; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String result = "";
        String [] strArray= str.split("-");
        for (int i = 0; i < strArray.length; i++) {
            result += strArray[i].charAt(0);
        }

        System.out.println(result);
    }


}

package com.example.kotlinTest;

import java.util.Arrays;
import java.util.Scanner;

public class JavaTest3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initInt = scanner.nextInt();

        int[][] arr = new int[initInt][initInt];

        for (int i = 0; i <initInt ; i++) {
            for (int j = 0; j <initInt ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i <initInt ; i++) {
            for (int j = 0; j <initInt ; j++) {
                for (int k = 0; k <initInt ; k++) {
                    if (arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }
                }
            }
        }



        for (int[] ints : arr) {
            for (int num: ints) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}

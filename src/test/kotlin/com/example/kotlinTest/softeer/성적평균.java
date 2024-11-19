package com.example.kotlinTest.softeer;

import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.util.Scanner;

public class 성적평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < K ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            double sum = 0;
            int count = 0;
            for (int j = start-1; j < end ; j++) {
                sum += arr[j];
                count++;
            }

            System.out.println(String.format("%.2f", Math.round((sum / count) * 100) / 100.0));
        }
    }
}


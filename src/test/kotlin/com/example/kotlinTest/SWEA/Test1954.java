package com.example.kotlinTest.SWEA;

import java.io.IOException;
import java.util.Scanner;

public class Test1954 {
    static int[][] arr;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T ; i++) {
            int N = scanner.nextInt();

            arr = new int[N][N];
            int count = 1;
            int x = 0;
            int y = 0;
            int d = 0;

            while (count <= N * N) {
                arr[x][y] = count++;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
                    d = (d + 1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }

            outPut(i);
        }
    }


    private static void outPut(int index) {
        System.out.println("#"+ (index + 1));
        for (int[] ints : arr) {
            for (int n : ints) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

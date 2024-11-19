package com.example.kotlinTest.온다;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Test5 {

    @Test
    void case1() {
        assertThat(
                new Solution().solution(new int[]{3,2})
        ).isEqualTo(new int[][]{{}});
    }


    class Solution {
        static int dx[] = {0, 1, 0, -1};
        static int dy[] = {1, 0, -1, 0};
        static int[][] arr;
        static int size;

        public int[][] solution(int[] lengths) {
            int[][] answer = {};

            size = lengths[0] * lengths[1];

            arr = new int[size][size];
            List<int[]> startList = new ArrayList<>();

            for (int i = 0; i < size; i++) {

            }
            print(0, 0, 3, 0);
            print(0,3,3,9);
            print(3,3,3,18);
            print(3,0,3,27);
            for (int[] ints : arr) {
                System.out.println(Arrays.toString(ints));
            }
            return answer;
        }

        private void print(int startX, int startY, int size, int n) {
            int count = 1;
            int d = 0;
            int x = startX;
            int y = startY;
            while (count <= size * size) {
                arr[x][y] = n + count++;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < startX || nx >= size + startX || ny < startY || ny >= size + startY || arr[nx][ny] != 0) {  //경계 벗어나거나, 숫자가 이미 존재하면
                    d = (d + 1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }
        }

    }
}

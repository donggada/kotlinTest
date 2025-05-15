package com.example.kotlinTest.백준.백준_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main15686 {
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> store = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        house = new ArrayList<>();
        store = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            String[] sp = br.readLine().split(" ");
            for (int j = 0; j <sp.length ; j++) {
                String st = sp[j];

                if (st.equals("0")) {
                    continue;
                }

                if (st.equals("1")) {
                    house.add(new int[]{i+1, j+1});
                    continue;
                }

                store.add(new int[]{i+1, j+1});
            }
        }

        visited = new boolean[store.size()];
        backTracking(0,0, m);
        System.out.println(result);
    }

    static private void backTracking(int depth,int count, int m) {
        if (count == m) {
            cal();
            return;
        }

        for (int i = depth; i < store.size() ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(i+1, count +1, m);
                visited[i] = false;
            }
        }
    }

    static private void cal() {
        int sum = 0;
        for (int[] housePoint : house) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < store.size() ; i++) {
                if (visited[i]) {
                    int[] storePoint = store.get(i);
                    min = Math.min(min, Math.abs(storePoint[0] - housePoint[0]) + Math.abs(storePoint[1] - housePoint[1]));
                }
            }
            sum += min;
        }

        result = Math.min(result, sum);
    }
}

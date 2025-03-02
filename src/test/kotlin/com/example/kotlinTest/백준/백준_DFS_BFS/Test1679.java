package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1679 {
    static HashSet<Integer> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        visited = new HashSet<>();

        System.out.println( bfs (N, K) );
    }

    private static int bfs(int location, int target) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{location, 0});

        visited.add(location);

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();

            if (pop[0] == target) {
                return pop[1];
            }

            int num1 = pop[0] + 1;
            int num2 = pop[0] - 1;
            int num3 = pop[0] * 2;


            if (num1 < 100001 && num1 > -1 && !visited.contains(num1)) {
                queue.add(new int[]{num1 ,pop[1] + 1});
                visited.add(num1);
            }

            if (num2 < 100001 && num2 > -1 && !visited.contains(num2)) {
                queue.add(new int[]{num2 ,pop[1] + 1});
                visited.add(num2);
            }

            if (num3 < 100001 && num3 > -1 && !visited.contains(num3)) {
                queue.add(new int[]{num3 ,pop[1] + 1});
                visited.add(num3);
            }
        }
        return -1;
    }
}

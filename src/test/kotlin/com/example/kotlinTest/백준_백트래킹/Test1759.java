package com.example.kotlinTest.백준_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Objects;

public class Test1759 {
    static int L;
    static int C;
    static String[] arr;
    static boolean[] visited;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        arr = new String[C];
        visited = new boolean[C];
        sb = new StringBuffer();

        String[] str = br.readLine().split(" ");

        System.arraycopy(str, 0, arr, 0, C);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        dfs(0, 0, 0);

        System.out.println(sb.toString());

    }


    private static void dfs(int depth, int index, int vowels) {
        if (depth == L) {
            if (vowels >= 1 && L - vowels >= 2) {
                for (int i = 0; i < C; i++) {
                    if (visited[i]) {
                        sb.append(arr[i]);
                    }
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = index; i < arr.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1,index + 1, isVowel(arr[i]) ?  vowels + 1 : vowels);
                visited[i] = false;
            }
        }

    }

    static boolean isVowel(String c) {
        return Objects.equals(c, "a") || Objects.equals(c, "e") || Objects.equals(c, "i") || Objects.equals(c, "o") || Objects.equals(c, "u");
    }
}

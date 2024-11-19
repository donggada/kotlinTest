package com.example.kotlinTest.softeer;
import java.io.*;
import java.util.*;
public class 연탄의크기 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] arr = new int[n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(arr);

            for (int i = 2; i < 101; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] % i == 0) {
                        count++;
                    }
                }
                answer = Math.max(answer, count);
            }

            System.out.println(answer);
        }


    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(s[i]);
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = 0; i < list.size() ; i++) {
            int count = 1;
            for (int j = i+1; j <list.size() ; j++) {
                if (list.get(j) % list.get(i) == 0) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}

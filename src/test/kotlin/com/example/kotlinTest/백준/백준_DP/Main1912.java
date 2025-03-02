package com.example.kotlinTest.백준.백준_DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main1912 {
    static HashMap<Integer, Integer> map;
    static List<Integer> list;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        map = new HashMap<>();
        list = new ArrayList<>();
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n ; i++) {
            list.add(Integer.valueOf(s[i]));
        }
        int init = list.get(0);
        map.put(0, init);
        max = init;

        topDown(n-1);

        System.out.println(max);
    }

    private static int topDown(int index) {
        if (map.containsKey(index)) {
            return map.get(index);
        }

        Integer num = list.get(index);
        map.put(index, Math.max(topDown(index -1) + num, num));

        max = Math.max(max, map.get(index));

        return map.get(index);
    }


//    static HashMap<Integer, Integer> memo;
//    static int max;
//    static ArrayList<Integer> list;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int  n = Integer.parseInt(br.readLine());
//        String[] arr = br.readLine().split(" ");
//
//        max = 0;
//        memo = new HashMap<>();
//
//        list = new ArrayList<>();
//
//        for (String s : arr) {
//            list.add(Integer.valueOf(s));
//        }
//
//        Integer initNum = list.get(0);
//        memo.put(0, initNum);
//        max = initNum;
//
//        dp(n -1);
//
//        System.out.println(max);
//    }
//
//    private static int dp(int index) {
//        if (memo.containsKey(index)) {
//            return memo.get(index);
//        }
//
//        Integer num = list.get(index);
//        memo.put(index, Math.max(dp(index - 1) + num, num));
//
//        max = Math.max(memo.get(index), max);
//        return memo.get(index);
//    }
}

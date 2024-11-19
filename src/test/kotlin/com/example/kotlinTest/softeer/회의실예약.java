package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실예약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        HashMap<String, List<int[][]>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), new ArrayList<>());
        }
        for (int i = 0; i < M ; i++) {
            String[] sp = br.readLine().split(" ");
            List<int[][]> list = map.get(sp[0]);
            list.add(new int[][]{{Integer.parseInt(sp[1]), Integer.parseInt(sp[2])}});
        }

        ArrayList<String> keyList = new ArrayList<>(map.keySet());

        Collections.sort(keyList);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keyList.size(); i++) {
            String k = keyList.get(i);
            sb.append("Room ").append(k).append(":").append("\n");
            List<int[][]> val = map.get(k);
            val.sort(Comparator.comparingInt(arr -> arr[0][0]));
            ArrayList<String> rList = new ArrayList<>();
            int start = 9;

            if (val.isEmpty()) {
                sb.append("1 available:").append("\n").append("09-18").append("\n").append("-----").append("\n");
                continue;
            }

            for (int idx =0; idx < val.size(); idx++) {
                int[][] arr = val.get(idx);
                if (arr[0][0] == arr[0][1]) {
                    continue;
                }
                if (arr[0][0] > start) {
                    rList.add(String.format("%02d", start) + "-" + String.format("%02d", arr[0][0]));
                }


                start = arr[0][1];

                if (idx == val.size()-1 && arr[0][1] < 18) {
                    rList.add(String.format("%02d", arr[0][1]) + "-" + 18);
                }
            }

            if (rList.isEmpty()) {
               sb.append("Not available").append("\n");
            }

            if (!rList.isEmpty()) {
                sb.append(rList.size()).append(" available:").append("\n");
            }
            for (String str: rList) {
                sb.append(str).append("\n");
            }

            if (i != keyList.size()-1) {
                sb.append("-----");
                sb.append("\n");
            }

        }

        System.out.println(sb);
    }
}

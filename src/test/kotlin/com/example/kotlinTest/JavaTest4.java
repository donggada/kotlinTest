package com.example.kotlinTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class JavaTest4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();
        String[] strings = next.split("_");
        int roomCount = Integer.parseInt(strings[0]);
        int roomInfoCount = Integer.parseInt(strings[1]);
        int n = roomCount + roomInfoCount;
        Map<String, boolean[]> map = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            boolean isRoomIndex = roomCount >= i + 1;
            String info = scanner.next();

            if (isRoomIndex) {
                map.put(info, new boolean[19]);
                continue;
            }

            String[] infoSplit = info.split("_");
            String room = infoSplit[0];
            int startTime = Integer.parseInt(infoSplit[1]) ;
            int endTime = Integer.parseInt(infoSplit[2]);

            cal(startTime, endTime, map.get(room));

        }

        Collection<boolean[]> values = map.values();
        for (boolean[] v:values) {
            System.out.println("v = " + Arrays.toString(v));
        }

        System.out.println("grandeur" + Arrays.toString(map.get("grandeur")));
        System.out.println("sonata" + Arrays.toString(map.get("sonata")));
        System.out.println("avante" + Arrays.toString(map.get("avante")));

    }

    private static void cal (int startTime, int endTime, boolean[] booleans) {
        for (int i = startTime; i <=endTime ; i++) {
            booleans[i] = true;
        }
    }


}

package com.example.kotlinTest.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class HSAT_6회_정기_코딩_인증평가_출퇴근길 {
    static HashSet<String> visited;
    static HashMap<String, HashSet<String>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new HashSet<>();
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            String sp[] = br.readLine().split(" ");
            HashSet<String> set = map.getOrDefault(sp[0], new HashSet<>());
            set.add(sp[1]);
            map.put(sp[0], set);
        }

        String[] info = br.readLine().split(" ");

        bfs(info[0],info[1]);
        visited.remove(info[0]);
        visited.remove(info[1]);

        System.out.println(visited.size());
    }

    private static void bfs(String start, String end) {
        HashSet<String> list = map.getOrDefault(start, new HashSet<>());
        LinkedList<String> queue = new LinkedList<>();

        for(String key : list) {
            queue.add(key);
        }

        while(!queue.isEmpty()) {
            String key = queue.pop();

            if (end.equals(key)) {
                continue;
            }

            for(String newKey : map.getOrDefault(key, new HashSet<>())) {
                if (!visited.contains(newKey)) {
                    queue.add(newKey);
                    visited.add(newKey);
                }
            }
        }

    }
}

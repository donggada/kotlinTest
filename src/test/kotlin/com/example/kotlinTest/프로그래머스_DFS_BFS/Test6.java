package com.example.kotlinTest.프로그래머스_DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test6 {

    @Test
    void  test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution(
                new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})
            ).isEqualTo(
                new String[]{"ICN", "JFK", "HND", "IAD"}
        );

        Assertions.assertThat(
            solution.solution(
                new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})
        ).isEqualTo(
            new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
        );




    }

    class Solution {
        static ArrayList<String> result;
        static HashMap<String, List<String>> root;
        static LinkedList<String> queue;
        static HashSet<String> visit;
        static boolean[] ch;
        static ArrayList<String> route;
        public String[] solution(String[][] tickets) {
//            result = new ArrayList<>();
//            root = new HashMap<>();
//            queue = new LinkedList<>();
//            visit = new HashSet<>();
//
//
//            for (int i = 0; i < tickets.length; i++) {
//                String start = tickets[i][0];
//                String end = tickets[i][1];
//
//                if (root.containsKey(start)) {
//                    root.get(start).add(end);
//                } else {
//                    List<String> list = new ArrayList<>();
//                    list.add(end);
//                    root.put(start, list);
//                }
//            }
//
//            for (String key : root.keySet()) {
//                Collections.sort(root.get(key));
//            }
//            queue.add("ICN");
//            result.add("ICN");
//
//            while (!queue.isEmpty()) {
//                bfs();
//            }
//
//
//            if (result.size() == tickets.length + 1) {
//                List<String> keyList = new ArrayList<>();
//
//                for (String key : root.keySet()) {
//                    keyList.add(key);
//                }
//
//                Collections.sort(keyList);
//
//                for (int i = 0; i < keyList.size() ; i++) {
//                    String key = keyList.get(i);
//                    if (!visit.contains(key)) {
//                        queue.add(key);
//                        result.add(key);
//                    }
//                }
//            }
//
//            return result.toArray(new String[0]);

            String[] answer = {};
            ch = new boolean[tickets.length];
            route = new ArrayList<>();

            DFS("ICN", "ICN", tickets, 0);

            Collections.sort(route);
            answer = route.get(0).split(" ");
            return answer;
        }

        private void bfs() {
            String curNode = queue.pop();

            List<String> nextNodeList = root.getOrDefault(curNode, new ArrayList<>());

            if (!nextNodeList.isEmpty()) {
                String nextNode = nextNodeList.get(0);
                queue.add(nextNode);
                result.add(nextNode);
                nextNodeList.remove(0);

                if (nextNodeList.isEmpty()) {
                    visit.add(curNode);
                }
            }
        }
        public void DFS(String dpt, String arr, String[][] tickets, int cnt){
            if(cnt == tickets.length) {
                route.add(arr);
                return;
            }

            for(int i = 0; i < tickets.length; i++) {
                if(dpt.equals(tickets[i][0]) && !ch[i]) {
                    ch[i] = true;
                    DFS(tickets[i][1], arr + " " + tickets[i][1], tickets, cnt + 1);
                    ch[i] = false;
                }
            }
        }
    }
}

package com.example.kotlinTest.잡다;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test4 {
    Solution solution = new Solution();


    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(
                        3,
                        new int[][]{{2,2},{5,5}, {1,7}},
                        2)
        ).isEqualTo(
                2
        );
    }


    class Solution {
        static int max = 0;
        static int answer;
        static HashMap<Integer, Integer> map;
        public int solution(int N, int[][] H, int D) {
            answer = 0;
            boolean[] visited = new boolean[N];
            Queue<int[]> queue = new LinkedList<>();
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int y = H[i][1];
                if (y <= D) {
                    queue.add(H[i]);
                    dfs(1, 0, N, H,D,visited);
//                    visited[i] = true;
                    // answer++;
                }
            }

//            while(!queue.isEmpty()) {
//                int[] poll = queue.poll();
//
//                for(int i = 0; i < N; i++) {
//                    int x = H[i][0];
//                    int y = H[i][1];
//                    if (!visited[i]) {
//                        if(Math.pow(2*D,2) >= Math.pow(Math.abs(poll[0]-x),2) + Math.pow(Math.abs(poll[1]-y),2)) {
//                            queue.add(H[i]);
//                            visited[i] = true;
//                        }
//                    }
//                }
//
//            }
            ArrayList<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            return map.get(list.get(list.size()-1)) % 1000000009;
        }

        private void dfs(int depth, int index, int N, int[][] H, int D, boolean[] visited) {
            if (depth == N) {
                map.put(H[index][1], map.getOrDefault(H[index][1],0)+1);
                return;
            }

            for (int i = 0; i < N; i++) {
                int x = H[i][0];
                int y = H[i][1];
                if (!visited[i]) {
                    if(Math.pow(2*D,2) >= Math.pow(Math.abs(H[i][0]-x),2) + Math.pow(Math.abs(H[i][1]-y),2)) {
                        visited[i] = true;
                        dfs(depth + 1, i, N, H, D ,visited);
                        visited[i] = false;
                    }
                }
            }

        }
    }
}



package com.example.kotlinTest.프로그래머스.프로그래머스_그래프;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test1 {

    @Test
    void test () {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})
        ).isEqualTo(
                3
        );
    }

    class Solution {
        static HashMap<Integer, List<Integer>> map;
        static boolean[] visit;
        public int solution(int n, int[][] edge) {
            visit=new boolean[n+1];
            map = new HashMap<>();
            for (int[] ins : edge) {
                int from = ins[0];
                int to = ins[1];

                List<Integer> fromList = map.getOrDefault(from, new ArrayList<>());
                List<Integer> toList = map.getOrDefault(to, new ArrayList<>());

                fromList.add(to);
                toList.add(from);

                map.put(from, fromList);
                map.put(to, toList);
            }


            return bfs();
        }

        public static int bfs(){
            visit[1]=true;
            Queue<Integer> queue= new LinkedList<>();
            queue.add(1);

            int result = 0;
            int size;

            while (!queue.isEmpty()){
                size = queue.size();

                for (int i = 0; i < queue.size() ; i++) {
                    Integer poll = queue.poll();
                    List<Integer> nextList = map.getOrDefault(poll, new ArrayList<>());

                    for (Integer node : nextList) {
                        if (!visit[node]) {
                            visit[node] = true;
                            queue.add(node);
                        }
                    }
                }

                result = size;
            }

            return result;
        }


    }

}

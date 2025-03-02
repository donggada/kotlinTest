package com.example.kotlinTest.백준.백준_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test8972 {
    static int[] dx = {1,  1,  1,  0,  0,  0, -1, -1, -1};
    static int[] dy = {-1, 0,  1, -1,  0,  1, -1,  0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        String[][] map = new String[R][C];
        int [] start  = {0,0};
        List<List<Integer>> robots = new ArrayList<>();

        for (int i = 0; i < R ; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length ; j++) {
                if (split[j].equals("I")) {
                    start = new int[]{i,j};
                }

                if (split[j].equals("R")) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    robots.add(list);
                }

                map[i][j] = split[j];
            }
        }

        String[] moveInfo = br.readLine().split("");

        LinkedList<List<Integer>> queue = new LinkedList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (List list: robots) {
            queue.add(list);
        }

        for (int i = 0; i <moveInfo.length ; i++) {
            int index = Integer.parseInt(moveInfo[i]) -1;

            int nx = start[0] + dx[index];
            int ny = start[1] + dy[index];
            map[start[0]][start[1]] = ".";
            map[nx][ny] = "I";
            start = new int[]{nx, ny};

            set = new HashSet<>();
            while (!queue.isEmpty()){
                set.add(queue.poll());
            }

            HashSet<List<Integer>> duplicate = new HashSet<>();
            for (List<Integer> r: set) {
                List<Integer> mr = new ArrayList<>();
                int mrX = r.get(0);
                int mrY = r.get(1);

                if (start[0] != r.get(0)) {
                    if (start[0] > r.get(0)) {
                        mrX += 1;
                    } else {
                        mrX -= 1;
                    }
                }

                if (start[1] !=r.get(1)) {
                    if (start[1] > r.get(1)) {
                        mrY += 1;
                    } else {
                        mrY -= 1;
                    }
                }

                if(check(start, mrX, mrY)){
                    System.out.println("kraj " + (i+1));
                    return;
                }

                map[r.get(0)][r.get(1)] = ".";
                map[mrX][mrY] = "R";

                mr.add(mrX);
                mr.add(mrY);

                if (duplicate.contains(mr)) {
                    map[mrX][mrY] = ".";
                    queue.remove(mr);
                } else {
                    duplicate.add(mr);
                    queue.add(mr);
                }

            }
        }

        for (String[] m : map) {
            for (String st : m) {
                System.out.print(st);
            }
            System.out.println();
        }
    }

    private static boolean check(int[] start, int mrX, int mrY) {
        return start[0] == mrX && start[1] == mrY;
    }
}

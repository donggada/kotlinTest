package com.example.kotlinTest.softeer;
import java.io.*;
import java.util.*;
public class 장애물인식프로그램 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0,  1, -1};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InpuntStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N  = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    dfs(new int[]{i,j}, N);
                }
            }
        }

        Collections.sort(result);

        result.stream().forEach(System.out::println);

    }
    private static int dfs(int[] move, int N) {
        int x = move[0];
        int y = move[1];

        if (visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(move);
        int count = 0;
        while(!queue.isEmpty()) {
            int[] pop = queue.pop();

            for (int i = 0; i < 4; i ++) {
                int nx = pop[0] + dx[i];
                int ny = pop[1] + dy[i];

                if (nx > -1 && ny > -1 && nx < N && ny < N) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

package com.example.kotlinTest.line_plus;

import kotlin.sequences.TakeSequence;

import java.util.*;

public class Test4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int duration = sc.nextInt();
            int income = sc.nextInt();
            tasks.add(new Task(start, duration, income));
        }
        Collections.sort(tasks);

        LinkedList<int[]> queue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            for (int i = 0; i <queue.size() ; i++) {

            }
        }


    }
    static class Task implements Comparable<Task> {
        int start;
        int duration;
        int income;
        int end;

        public Task(int start, int duration, int income) {
            this.start = start;
            this.duration = duration;
            this.income = income;
            this.end = start + duration;
        }

        @Override
        public int compareTo(Task o) {
            return this.end - o.end;
        }
    }

}




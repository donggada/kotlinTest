package com.example.kotlinTest.NexonTutorial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test3 {


    @Test
        void case1() {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            list.add(2);
            list.add(4);
            Assertions.assertThat(Test3.findMinGeneration(list)).isEqualTo(6);
        }

    @Test
    void case2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(6);
        Assertions.assertThat(Test3.findMinGeneration(list)).isEqualTo(4);
    }

    @Test
    void case3() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); //1
        list.add(1); // 3
        list.add(1);// 5
        list.add(1); //6
        list.add(2);
        Assertions.assertThat(Test3.findMinGeneration(list)).isEqualTo(6);
    }

    public static long findMinGeneration(List<Integer> layer) {
        long index = 1;
        Integer max = layer.stream().max(Integer::compareTo).orElse(0);
        PriorityQueue<Integer> queue =  new PriorityQueue<>();
        layer.stream().filter(i -> i < max).forEach(i -> queue.add(i));

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            int sum;

            if (index % 2 == 1) {
                sum = poll + 1;

                if (poll + 2 == max) {
                    queue.add(poll);
                    if (queue.peek() != poll && queue.peek() + 1 < max ) {
                        queue.add(queue.poll()+1);
                    }else if(queue.peek() + 1 == max) {
                        queue.poll();
                    }
                }  else if (sum < max){
                    queue.add(sum);
                }
            } else {
                sum = poll + 2;

                if (poll + 1 == max) {
                    queue.add(poll);
                    if (queue.peek() != poll && queue.peek() + 2 < max ) {
                        queue.add(queue.poll()+2);
                    }else if(queue.peek() + 2 == max) {
                        queue.poll();
                    }
                }  else if (sum < max){
                    queue.add(sum);
                }
            }

            index++;
        }

        return index;
    }




}

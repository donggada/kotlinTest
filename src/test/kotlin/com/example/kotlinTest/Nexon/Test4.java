package com.example.kotlinTest.Nexon;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class Test4 {



    @Test
    void test () {
        Assertions.assertThat(
            Test4.getServerIndex(3, List.of(2,4,1,8,9), List.of(7,9,2,4,5))
        ).isEqualTo(
            List.of(1,2,1,3,2)
        );

    }

    public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
        List<Integer> serverIndices = new ArrayList<>();
        int[] serverEndTime = new int[n];

        for (int i = 0; i < arrival.size(); i++) {
            int requestArrival = arrival.get(i);
            int requestBurstTime = burstTime.get(i);

            int minEndTime = Integer.MAX_VALUE;
            int assignedServer = -1;

            // 모든 서버를 확인하여 현재 요청을 처리할 수 있는 서버를 찾습니다.
            for (int j = 0; j < n; j++) {
                if (serverEndTime[j] <= requestArrival && serverEndTime[j] < minEndTime) {
                    minEndTime = serverEndTime[j];
                    assignedServer = j;
                }
            }

            // 요청이 할당된 서버의 인덱스를 기록합니다.
            serverIndices.add(assignedServer + 1);

            // 할당된 서버의 종료 시간을 갱신합니다.
            serverEndTime[assignedServer] = requestArrival + requestBurstTime;
        }

        return serverIndices;
    }
}



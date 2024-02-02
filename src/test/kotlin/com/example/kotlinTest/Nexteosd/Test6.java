package com.example.kotlinTest.Nexteosd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test6 {

    @Test
    void test() {

//        List<String> requestStatus = Test2.getRequestStatus(List.of(
//            "www.abc.com",
//            "www.hd.com",
//            "www.abc.com",
//            "www.pqr.com",
//            "www.abc.com",
//            "www.pqr.com",
//            "www.pqr.com"
//        ));
        Assertions.assertThat(Test6.minimumCost(
            List.of(3,1,2,3,1),
            List.of(List.of(3,4,1), List.of(1,5,5))
            )
        ).isEqualTo(10);

    }


    public static int minimumCost(List<Integer> cost, List<List<Integer>> offer) {
        int n = cost.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += cost.get(i);
        }

        for (List<Integer> off : offer) {
            int offerCost = off.get(off.size() - 1);
            boolean isApplicable = true;
            for (int i = 0; i < off.size() - 1; i++) {
                if (off.get(i) > cost.get(i)) {
                    isApplicable = false;
                    break;
                }
            }
            if (isApplicable) {
                int offerTotal = 0;
                for (int i = 0; i < n; i++) {
                    offerTotal += Math.max(cost.get(i) - off.get(i), 0);
                }
                result = Math.min(result, offerTotal + offerCost);
            }
        }

        return result;
    }

    private static int calculateCost(List<Integer> cost, List<List<Integer>> offer) {
        int n = cost.size();
        int minCost = 0;

        for (int i = 0; i < n; i++) {
            minCost += cost.get(i); // 초기 비용은 각 제품의 가격으로 설정
        }

        for (List<Integer> o : offer) {
            int offerCost = o.get(o.size() - 1); // 할인 가격
            boolean isApplicable = true;
            for (int i = 0; i < o.size() - 1; i++) {
                if (o.get(i) > cost.get(i)) { // 할인 제안이 적용 가능한지 확인
                    isApplicable = false;
                    break;
                }
            }
            if (isApplicable) {
                int offerTotal = 0;
                for (int i = 0; i < n; i++) {
                    offerTotal += Math.max(cost.get(i) - o.get(i), 0); // 할인이 적용된 가격 합산
                }
                minCost = Math.min(minCost, offerTotal + offerCost); // 최소 비용 갱신
            }
        }

        return minCost;
    }




}

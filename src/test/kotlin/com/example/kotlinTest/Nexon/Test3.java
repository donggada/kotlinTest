package com.example.kotlinTest.Nexon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Test3 {

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
        List<String> requestStatus = Test3.getRequestStatus(List.of(
            "www.hr.com",
            "www.hr.com",
            "www.hr.com",
            "www.hr.com"
        ));

        System.out.println("requestStatus = " + requestStatus);


    }


    public static List<String> getRequestStatus(List<String> requests) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> lastRequestTimeMap = new HashMap<>();
        Map<String, Integer> requestCountMap = new HashMap<>();
        String successMessage = "{status 200, message: OK}";
        String failMessage = "{status 429, message: Too many requests}";

        for (int time = 0; time < requests.size()  ; time++) {
            String uri = requests.get(time);

            int lastRequestTime = lastRequestTimeMap.getOrDefault(uri, -1);
            int requestCount = requestCountMap.getOrDefault(uri, 0);

            if (time - lastRequestTime <= 5 && requestCount >= 2) {
                result.add(failMessage);
            } else if (time - lastRequestTime <= 30 && requestCount >= 5) {
                result.add(failMessage);
            } else {
                lastRequestTimeMap.put(uri, time);
                requestCountMap.put(uri, requestCount + 1);
                result.add(successMessage);
            }
        }

        return result;
    }



}

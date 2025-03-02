package com.example.kotlinTest.kakaomobility_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test1 {
    Solution solution = new Solution();

    @Test
    void test() {
        Assertions.assertThat(
                        solution.solution(
                                "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker",
                                "Example")
                )
                .isEqualTo(
                        "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>"
                );

    }

    class Solution {
        public String solution(String S, String C) {
            HashMap<String, Integer> nameMap = new HashMap<>();
            String[] nameArray = S.split(",");
            StringBuffer sb = new StringBuffer();


            for (int i = 0; i < nameArray.length ; i++) {
                String name = nameArray[i];
                sb.append(name).append(" ");

                sb.append(makeEmail(name.trim(), C, nameMap));

                if (i != nameArray.length-1) {
                    sb.append(",");
                }
            }

            return sb.toString();
        }

        private String makeEmail(String name, String company, HashMap<String, Integer> nameMap) {
            String[] arr = name.split(" ");
            String result = "<%s@" + company.toLowerCase() + ".com>";
            String email;

            if (arr.length == 2) {
                String first = arr[0].substring(0, 1).toLowerCase();
                String last = arr[1].substring(0, Math.min(arr[1].length(), 8)).toLowerCase();
                email = first + last;
                if(nameMap.containsKey(email)) {
                    int count = nameMap.get(email) + 1;
                    nameMap.put(email, count);
                    return "<" + email + count + "@" + company.toLowerCase() + ".com>";
                }

                nameMap.put(email, 1);
                return "<" + email + "@" + company.toLowerCase() + ".com>";
            }



            String first = arr[0].substring(0, 1).toLowerCase();
            String middle = arr[1].substring(0, 1).toLowerCase();
            String last = arr[2].replace("-", "").substring(0, Math.min(arr[2].length(), 8)).toLowerCase();
            email = first + middle + last;

            if(nameMap.containsKey(email)) {
                int count = nameMap.get(email) + 1;
                nameMap.put(email, count);
                return "<" + email + count + "@" + company.toLowerCase() + ".com>";
            }

            nameMap.put(email, 1);
            return "<" + email + "@" + company.toLowerCase() + ".com>";
        }
    }
}

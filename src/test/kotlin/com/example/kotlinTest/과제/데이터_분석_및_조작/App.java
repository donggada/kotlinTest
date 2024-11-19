package com.example.kotlinTest.과제.데이터_분석_및_조작;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App {


    public static void main(String[] args) throws IOException {
        String directoryPath = "data/output";
        List<Customer> data = parseCustomers(new String(Files.readAllBytes(Paths.get("data", "input/customer.json"))));

        int size = data.size();
        System.out.println(size);

        List<Long> list = data.stream().sorted(Comparator.comparingLong(Customer::getCustomerId)).map(Customer::getCustomerId).toList();
        System.out.println(list);

        Files.createDirectories(Paths.get(directoryPath));

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + "/problem_1.json"))) {
            writer.write("{\n");
            writer.write("    \"total\": " + size + "\n");
            writer.write("}\n");
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + "/problem_2.json"))) {
            writer.write(list.toString());
        }



//        objectMapper.writeValue(new File(directoryPath + "/problem_1.json"), Map.of("total", size));
//        objectMapper.writeValue(new File(directoryPath + "/problem_2.json"), list);
    }


    private static List<Customer> parseCustomers(String jsonContent) {
        List<Customer> customers = new ArrayList<>();

        // JSON 배열의 시작과 끝을 제거
        jsonContent = jsonContent.trim();
        if (jsonContent.startsWith("[") && jsonContent.endsWith("]")) {
            jsonContent = jsonContent.substring(1, jsonContent.length() - 1).trim();
        }
        String[] split = jsonContent.split("},");
        // 고객 객체 생성
        for (String s : split) {
            String trimString = s.trim().split("}")[0];
            String[] infos = trimString.split(",");
            Customer customer = new Customer();
            for (int i = 0; i < infos.length; i++) {
                String val = infos[i].split(":")[1];
                String info = infos[i].split(":")[1].substring(1, val.length());
                if (i == 0) {
                    customer.customerId = Long.parseLong(info);
                    continue;
                }
                if (i == 1) {
                    customer.name = info;
                    continue;
                }
                customer.status = info;
            }
            customers.add(customer);
        }

        return customers;
    }

    static class Customer {
        @JsonProperty("customer_id")
        Long customerId;
        @JsonProperty("name")
        String name;
        @JsonProperty("status")
        String status;

        public Long getCustomerId() {
            return customerId;
        }
    }
}

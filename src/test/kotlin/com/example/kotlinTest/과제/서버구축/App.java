package com.example.kotlinTest.과제.서버구축;



import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(5678), 0);
        httpServer.createContext("/", new MyHandler1());
        httpServer.createContext("/sum", new MyHandler2());
        httpServer.setExecutor(null);
        httpServer.start();
    }

    static class MyHandler1 implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String response = """
                    {
                            "message" : "server check"                    
                    }
                    """;

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(response.getBytes());
            responseBody.close();
        }
    }


    static class MyHandler2 implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String currentDir = System.getProperty("user.dir");
            String path = "/src/test/kotlin/com/example/kotlinTest/과제/user.json";
//            User[] users = new ObjectMapper().readValue(new File(currentDir + path), User[].class);
            int sum = 0;
//
//            for (User user: users) {
//                sum += user.postCount;
//            }

            StringBuilder jsonBuilder = new StringBuilder();
            // 파일 읽기
            try (BufferedReader br = new BufferedReader(new FileReader(currentDir + path))) {
                String line;
                while ((line = br.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonString = jsonBuilder.toString();

            String[] users = jsonBuilder.substring(1, jsonString.length() - 1).split("},");

            for (String user : users) {
                String[] split = user.split("post_count\":");
                sum += Integer.parseInt(split[1].split("}")[0].trim());
            }

//            System.out.println(sum);

            String response = "{\"sum\": " + sum + "}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(response.getBytes());
            responseBody.close();
        }
    }



    static class User {
//        @JsonProperty("user_id")
        Long userId;
//        @JsonProperty("username")
        String username;
//        @JsonProperty("post_count")
        int postCount;

        public User(Long userId, String username, int postCount) {
            this.userId = userId;
            this.username = username;
            this.postCount = postCount;
        }

        public User() {

        }
    }
}


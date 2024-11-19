package com.example.kotlinTest.과제.승률조작;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    public static class ApiController {
//        private final String DATA_DIR = "../data/input";
//        private final String DATA_DIR = System.getProperty("user.dir") + "/src/test/kotlin/com/example/kotlinTest/과제/승률조작";
        private final ObjectMapper objectMapper = new ObjectMapper();

        @GetMapping("/api/gamerecord/users")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> getUsers() {
            try {
                return ResponseEntity.ok(getUserList().sorted(
                        (user1, user2) -> user1.getUsername() == user2.getUsername()
                                ? user1.getTag().compareTo(user2.getTag())
                                : user1.getUsername().compareTo(user2.getUsername())
                ).map(UserDto::of).toList());
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping("/api/gamerecord/winrate")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> getWinrate(String username, String tag) {
            try {
                if (username == null || tag == null) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorDto.unauthorizedOf());
                }

                Optional<User> optional = getUserList().filter(user -> user.findUserNameAndTag(username, tag)).findAny();

                if (optional.isPresent()) {
                    User user = optional.get();
                    return ResponseEntity.ok(WinrateDto.of(user.getWinrate()));
                }

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.notFoundOf());
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        private Stream<User> getUserList() throws IOException {
            return Arrays.stream(objectMapper.readValue(Files.readAllBytes(Paths.get("data", "input/records.json")), User[].class));
//            return Arrays.stream(objectMapper.readValue(Files.readAllBytes(Paths.get(DATA_DIR, "records.json")), User[].class));
        }
    }

    static class UserDto {
        private String tag;
        private String username;

        public static UserDto of (User user) {
            return new UserDto(user.username, user.getTag());
        }

        public UserDto(String username, String tag) {
            this.username = username;
            this.tag = tag;
        }

        public String getUsername() {
            return username;
        }

        public String getTag() {
            return tag;
        }
    }

    static class WinrateDto {
        private int winrate;

        public static WinrateDto of(int winrate) {
            return new WinrateDto(winrate);
        }

        public WinrateDto(int winrate) {
            this.winrate = winrate;
        }

        public int getWinrate() {
            return winrate;
        }
    }

    static class ErrorDto {
        private String error;

        public static ErrorDto notFoundOf() {
            return new ErrorDto("data not found");
        }

        public static ErrorDto unauthorizedOf() {
            return new ErrorDto("Invalid data format");
        }

        public ErrorDto(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }


    static class User {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("username")
        private String username;
        @JsonProperty("tag")
        private String tag;
        @JsonProperty("win")
        private int win;
        @JsonProperty("lose")
        private int lose;

        public User() {

        }

        public int getWinrate() {
            return (int) ((double) (win * 100 / (win + lose)));
        }

        public boolean findUserNameAndTag(String username, String tag) {
            return this.username.equals(username) && this.tag.equals(tag);
        }

        public User(Long id, String username, String tag, int win, int lose) {
            this.id = id;
            this.username = username;
            this.tag = tag;
            this.win = win;
            this.lose = lose;
        }

        public String getUsername() {
            return username;
        }

        public String getTag() {
            return tag;
        }

    }

}


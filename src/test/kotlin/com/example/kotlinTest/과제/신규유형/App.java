package com.example.kotlinTest.과제.신규유형;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RestController
    public static class ApiController {
         private final String DATA_DIR = "data/input";

        private final ObjectMapper objectMapper = new ObjectMapper();

        @GetMapping("/api/reservation/search")
        // 여기에 코드를 작성하세요.
        public ResponseEntity<?> login(String customerName) {

            if (customerName == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.of());
            }

            try {
                List<Reservation> list = getReservations().stream().sorted(Comparator.comparing(Reservation::getCheckIn)).toList();

                if (customerName.equals("all")) {
                    return ResponseEntity.ok(list);
                }

                return ResponseEntity.ok(list.stream().filter(r -> r.isMatchName(customerName)).toList());
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        private List<Reservation> getReservations() throws IOException {
            return Arrays.stream(objectMapper.readValue(Files.readAllBytes(Paths.get(DATA_DIR, "reservation.json")), Reservation[].class)).toList();
        }

        static class Reservation {
            @JsonProperty("id")
            String id;
            @JsonProperty("customer_name")
            String customerName;
            @JsonProperty("check_in")
            String checkIn;
            @JsonProperty("check_out")
            String checkOut;
            @JsonProperty("status")
            String status;

            public boolean isMatchName(String name) {
                return customerName.contains(name);
            }

            public String getCheckIn() {
                return checkIn;
            }
        }

        static class ErrorDto {
            private String error;

            public static ErrorDto of() {
                return new ErrorDto("customerName name is required");
            }

            public ErrorDto(String error) {
                this.error = error;
            }

            public String getError() {
                return error;
            }
        }
    }


}

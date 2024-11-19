package com.example.kotlinTest.과제.그로들;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        new ApiController().searchInventory("uponstar");
    }

    @RestController
    public static class ApiController {

        private final ObjectMapper objectMapper = new ObjectMapper();

        private List<Inventory> inventories = getInventories();
        private List<Product> products = getProducts();

        @GetMapping("/api/inventories/search")
        public ResponseEntity<?> searchInventory(String productName) {
            try {
                if (productName == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.errorOfMissingQueryParam());
                }

                if (containsWhitespaceOrSpecialChars(productName)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.errorOfQueryParamSpacesAndSpecialCharacters());
                }

                Product findProduct = products.stream().filter(product -> product.isSameProductName(productName)).findFirst().orElseThrow(() -> new Exception("Product Not found"));

                Map<Integer, List<Inventory>> collect = inventories.stream().collect(Collectors.groupingBy(Inventory::getProductId));
                int total = collect.getOrDefault(findProduct.id, new ArrayList<>()).stream().mapToInt(Inventory::getQuantity).sum();

                return ResponseEntity.ok(SearchInventoryResponse.of(findProduct, total));
            } catch (Exception e) {
                if (e.getMessage().equals("Product Not found")) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.errorOfNotFound());
                }
                e.printStackTrace();
                return ResponseEntity.internalServerError().body("Error reading inventories file");
            }
        }

        @PostMapping("/api/products")
        public ResponseEntity<?> updateOrAddProduct(String productName, int quantity) {
            try {
                if (productName == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.errorOfMissingQueryParam());
                }

                if (containsWhitespaceOrSpecialChars(productName)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.errorOfQueryParamSpacesAndSpecialCharacters());
                }

                Product findProduct = products.stream().filter(product -> product.isSameProductName(productName)).findFirst().orElseThrow(() -> new Exception("Product Not found"));
                Map<Integer, List<Inventory>> collect = inventories.stream().collect(Collectors.groupingBy(Inventory::getProductId));
                Inventory findInventory = collect.getOrDefault(findProduct.id, new ArrayList<>()).stream().findFirst().orElseThrow(() -> new Exception("Product Not found"));
                findInventory.updateQuantity(quantity);
                return ResponseEntity.ok(findInventory);
            } catch (Exception e) {
                e.printStackTrace();
                if (e.getMessage().equals("Product Not found")) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.errorOfNotFound());
                }
                return ResponseEntity.internalServerError().body("Error reading products file");
            }
        }
        public static boolean containsWhitespaceOrSpecialChars(String input) {
            return input.matches(".*[\\s\\W].*");
        }

        private List<Inventory> getInventories() {
            try {
                return Arrays.stream(objectMapper.readValue(Files.readAllBytes(Paths.get("data/input/inventories.json")), Inventory[].class)).toList();
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }

        private List<Product> getProducts() {
            try {
                return Arrays.stream(objectMapper.readValue(Files.readAllBytes(Paths.get("data/input/products.json")), Product[].class)).toList();
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
    }


    static class Inventory {
        @JsonProperty("id")
        private int id;

        @JsonProperty("productId")
        private int productId;

        @JsonProperty("quantity")
        private int quantity;

        public void updateQuantity(int updateQuantity) {
            this.quantity = updateQuantity;
        }


        public int getId() {
            return id;
        }

        public int getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    static class Product {
        @JsonProperty("id")
        private int id;

        @JsonProperty("productName")
        private String productName;

        public boolean isSameProductName(String name) {
            return productName.equals(name);
        }

        public int getId() {
            return id;
        }

        public String getProductName() {
            return productName;
        }
    }

    static class SearchInventoryResponse {
        private int id;
        private String productName;
        private int quantity;

        public static SearchInventoryResponse of (Product product, int quantity) {
            return new SearchInventoryResponse(product.id, product.productName, quantity);
        }

        public int getId() {
            return id;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        private SearchInventoryResponse(int id, String productName, int quantity) {
            this.id = id;
            this.productName = productName;
            this.quantity = quantity;
        }
    }

    static class ErrorDto {
        private String error;

        public static ErrorDto errorOfNotFound() {
            return new ErrorDto("Product Not found");
        }

        public static ErrorDto errorOfMissingQueryParam() {
            return new ErrorDto("Missing product name or quantity. Both fields are required.");
        }

        public static ErrorDto errorOfQueryParamSpacesAndSpecialCharacters() {
            return new ErrorDto("Invalid product name. Product names cannot contain spaces or special characters.");
        }

        public ErrorDto(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }

}

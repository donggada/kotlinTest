package com.example.kotlinTest.softeer;

import java.io.*;
public class 비밀메뉴 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine().split(" ");
        String secretString = br.readLine().replace(" ", "");
        String arr = br.readLine().replace(" ", "");

        if (arr.contains(secretString)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}

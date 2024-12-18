package com.example.kotlinTest.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = init();

        String s = br.readLine();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += map.getOrDefault(s.charAt(i),0);
        }

        System.out.println(result);
    }

    private static HashMap<Character, Integer> init() {
        return new HashMap<>() {{
            "ABC".chars().forEach(c -> put((char) c, 3));
            "DEF".chars().forEach(c -> put((char) c, 4));
            "GHI".chars().forEach(c -> put((char) c, 5));
            "JKL".chars().forEach(c -> put((char) c, 6));
            "MNO".chars().forEach(c -> put((char) c, 7));
            "PQRS".chars().forEach(c -> put((char) c, 8));
            "TUV".chars().forEach(c -> put((char) c, 9));
            "WXYZ".chars().forEach(c -> put((char) c, 10));
        }};
    }

}

package com.example.kotlinTest.백준.백준_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test16916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        HashSet<String> set = new HashSet<>();

        char key = P.charAt(0);
        int length = P.length();
        for (int i = 0; i <S.length() ; i++) {
            if (S.charAt(i) == key && i + length <= S.length()) {
                boolean check = true;
                for (int j = 0; j < length ; j++) {
                    if(S.charAt(i + j) != P.charAt(j)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    System.out.println(1);
                    return;
                }

            }

        }


        System.out.println(0);


    }
}

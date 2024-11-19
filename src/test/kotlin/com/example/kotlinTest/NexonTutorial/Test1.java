package com.example.kotlinTest.NexonTutorial;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();
        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            String[] lineSp = line.split("\"");
            if (lineSp[1].equals("GET") && lineSp[2].equals("200")) {
                String[] sp = lineSp[1].split("HTTP")[0].split("/");
                System.out.println(sp[sp.length-1]);
            }
        }

    }
}

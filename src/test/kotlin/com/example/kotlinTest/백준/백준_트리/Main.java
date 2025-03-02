package com.example.kotlinTest.백준.백준_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, String[]> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        tree = new HashMap<>();

        for (int i = 0; i < size ; i++) {
            String next = br.readLine();
            String[] strings = next.split(" ");
            tree.put(strings[0], strings);
        }

        preorder("A");
        System.out.println("");
        inorder("A");
        System.out.println("");
        postorder("A");
        System.out.println("");


    }
    //전위순회
    private static void preorder(String root) {
        if (root.equals(".")) {
            return;
        }
        System.out.print(root);
        preorder(tree.get(root)[1]);
        preorder(tree.get(root)[2]);
    }

    //중위순회
    private static void inorder(String root) {
        if (root.equals(".")) {
            return;
        }
        inorder(tree.get(root)[1]);
        System.out.print(root);
        inorder(tree.get(root)[2]);

    }

    //후위순회
    private static void postorder(String root) {
        if (root.equals(".")) {
            return;
        }
        postorder(tree.get(root)[1]);
        postorder(tree.get(root)[2]);
        System.out.print(root);

    }

}

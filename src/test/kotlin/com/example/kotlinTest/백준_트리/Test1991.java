package com.example.kotlinTest.백준_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test1991 {

    static HashMap<String, List<String>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            String[] split = br.readLine().split(" ");
            List<String> list = tree.getOrDefault(split[0], new ArrayList<>());
            list.add(split[1]);
            list.add(split[2]);
            tree.put(split[0], list);
        }

        preorder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");
    }
    //전위순회
     private static void preorder(String root) {
         if (root.equals(".")) {
             return;
         }

         System.out.print(root);

         List<String> list = tree.getOrDefault(root, new ArrayList<>());
         for (String s : list) {
             preorder(s);
         }
     }

    //중위순회
    private static void inorder(String root) {
        List<String> list = tree.getOrDefault(root, new ArrayList<>());
        if (!list.get(0).equals(".")) {
            inorder(list.get(0));
        }

        System.out.print(root);

        if (!list.get(1).equals(".")) {
            inorder(list.get(1));
        }
    }

    //후위순회
    private static void postorder(String root) {
        if (root.equals(".")) {
            return;
        }

        List<String> list = tree.getOrDefault(root, new ArrayList<>());
        for (String s : list) {
            postorder(s);
        }
        System.out.print(root);
    }


}

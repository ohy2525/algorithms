package Doit.ch09;

import java.util.*;
import java.io.*;

public class 트리순회 {
    static HashMap<Character, char[]> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.put(root, new char[]{left, right});
        }
        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
        System.out.println();
    }

    private static void preOrder(char value) {
        if (value != '.') {
            System.out.print(value);
            preOrder(tree.get(value)[0]);
            preOrder(tree.get(value)[1]);
        }
    }

    private static void inOrder(char value) {
        if (value != '.') {
            inOrder(tree.get(value)[0]);
            System.out.print(value);
            inOrder(tree.get(value)[1]);
        }
    }

    private static void postOrder(char value) {
        if (value != '.') {
            postOrder(tree.get(value)[0]);
            postOrder(tree.get(value)[1]);
            System.out.print(value);
        }
    }
}

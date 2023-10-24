package Doit.ch06;

import java.util.*;
import java.io.*;

public class 문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String word = input[1];

            for (int j = 0; j < word.length(); j++) {
                for (int k = 0; k < R; k++) {
                    System.out.print(word.charAt(j));
                }
            }
            System.out.println();
        }
        br.close();
    }
}

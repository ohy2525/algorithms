package Doit.ch06;

import java.io.*;
import java.util.*;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int[] arr = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}

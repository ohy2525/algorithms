package Doit.ch08;

import java.util.*;
import java.io.*;

import java.util.stream.Collectors;

public class 최소최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        br.close();
        Collections.sort(arr);

        System.out.print(arr.get(0) + " " + arr.get(N - 1));
    }
}

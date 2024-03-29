package Doit.ch08;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class 평균 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> score = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        br.close();
        int max = Collections.max(score);
        int sum = score.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println((double) (sum * 100) / (max * N));
    }
}

package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class bj1076 {
    public static void main(String[] args) throws IOException {
        List<String> color = Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int f = color.indexOf(br.readLine());
        int s = color.indexOf(br.readLine());
        int t = color.indexOf(br.readLine());
        br.close();

        long result = Long.parseLong((Integer.toString(f) + Integer.toString(s))) * (int) Math.pow(10, t);
        System.out.println(result);
    }
}

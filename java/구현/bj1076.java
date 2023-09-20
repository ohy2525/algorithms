package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class bj1076 {
    public static void main(String[] args) throws IOException {
        List<String> color = Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input1 = reader.readLine();
        String input2 = reader.readLine();
        String input3 = reader.readLine();

        int f = color.indexOf(input1);
        int s = color.indexOf(input2);
        int t = Integer.parseInt(input3);

        int r = Integer.parseInt(String.valueOf((f + s) * (int) Math.pow(10, t)));
        System.out.println(r);
    }
}
